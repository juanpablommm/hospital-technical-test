package com.technical.test.hospital.quote.infraestructure;

import com.technical.test.hospital.doctor.infrastructure.DoctorEntity;
import com.technical.test.hospital.doctor.infrastructure.DoctorRepositoryJpa;
import com.technical.test.hospital.doctor.infrastructure.DoctorRepositoryJpaPostgres;
import com.technical.test.hospital.quote.domain.QuoteDomain;
import com.technical.test.hospital.quote.domain.QuoteRepository;
import com.technical.test.hospital.shared.infrastructure.HospitalApplicationException;
import com.technical.test.hospital.users.infrastructure.UserEntity;
import com.technical.test.hospital.users.infrastructure.UserRepositoryJpa;
import com.technical.test.hospital.users.infrastructure.UserRepositoryJpaPostgres;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Primary
@Component
public class QuoteRepositoryJpaPostgrest implements QuoteRepository{

    private final QuoteRepositoryJpa quoteRepositoryJpa;
    private final UserRepositoryJpa userRepositoryJpa;
    private final DoctorRepositoryJpa doctorRepositoryJpaPostgres;

    public QuoteRepositoryJpaPostgrest(QuoteRepositoryJpa quoteRepositoryJpa, UserRepositoryJpa userRepositoryJpa, DoctorRepositoryJpa doctorRepositoryJpaPostgres) {
        this.quoteRepositoryJpa = quoteRepositoryJpa;
        this.userRepositoryJpa = userRepositoryJpa;
        this.doctorRepositoryJpaPostgres = doctorRepositoryJpaPostgres;
    }

    @Transactional
    @Override
    public void create(QuoteDomain quoteDomain) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserEntity userEntity = this.userRepositoryJpa.findByEmailEqualsIgnoreCase(authentication.getName()).orElseThrow(
                () -> new HospitalApplicationException("The user is not authenticated", HttpStatus.UNAUTHORIZED)
        );

        final QuoteEntity quoteEntity = QuoteMapper.toEntity(quoteDomain);
        final DoctorEntity doctorEntity = this.doctorRepositoryJpaPostgres.findByFullName(quoteDomain.doctor())
                .orElseThrow(() -> new HospitalApplicationException("The doctor is not in control of scheduling an appointment",
                        HttpStatus.NOT_FOUND));

        quoteEntity.setUser(userEntity);
        quoteEntity.setDoctor(doctorEntity);
        this.quoteRepositoryJpa.save(quoteEntity);
    }

    @Override
    public Set<QuoteDomain> findQuoteByDate() {
        return Set.of();
    }

    @Override
    public Set<QuoteDomain> findQuoteByUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return this.quoteRepositoryJpa.findQuoteByUser(authentication.getName()).stream()
                .map(QuoteMapper::toDomain).collect(Collectors.toSet());
    }

    @Override
    public Set<QuoteDomain> findQuoteByDoctor(String fullName) {
        return Set.of();
    }

    @Transactional
    @Override
    public void cancelQuote(Long quoteId) {
        this.quoteRepositoryJpa.cancelQuoteById(quoteId);
    }
}
