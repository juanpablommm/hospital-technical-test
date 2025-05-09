package com.technical.test.hospital.doctor.infrastructure;

import com.technical.test.hospital.doctor.domain.DoctorDomain;
import com.technical.test.hospital.doctor.domain.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Primary
@Component
@AllArgsConstructor
public class DoctorRepositoryJpaPostgres implements DoctorRepository {

    private DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public void create(DoctorDomain doctorDomain) {
        this.doctorRepositoryJpa.save(DoctorMapper.toEntity(doctorDomain));
    }

    @Override
    public Set<DoctorDomain> findAll() {
        return this.doctorRepositoryJpa.findAll().stream()
                .map(DoctorMapper::toDomain)
                .collect(Collectors.toSet());
    }
}
