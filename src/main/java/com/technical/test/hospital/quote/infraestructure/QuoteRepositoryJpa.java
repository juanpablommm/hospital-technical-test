package com.technical.test.hospital.quote.infraestructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface QuoteRepositoryJpa extends JpaRepository<QuoteEntity, Long> {

    @Query("SELECT quote FROM QuoteEntity quote WHERE quote.date = :date")
    Set<QuoteEntity> findQuotesByDate(OffsetDateTime dateTime);

    @Query("SELECT quote FROM QuoteEntity quote WHERE quote.user.email = :email")
    List<QuoteEntity> findQuoteByUser(String email);

    @Modifying
    @Query("UPDATE QuoteEntity quote SET quote.isCancel = true WHERE quote.id = :id")
    void cancelQuoteById(Long id);
}
