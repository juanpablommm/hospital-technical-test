package com.technical.test.hospital.quote.domain;

import java.util.Set;

public interface QuoteRepository {

    void create(QuoteDomain quoteDomain);

    Set<QuoteDomain> findQuoteByDate();

    Set<QuoteDomain> findQuoteByUser();

    Set<QuoteDomain> findQuoteByDoctor(String fullName);

    void cancelQuote(Long quoteId);
}
