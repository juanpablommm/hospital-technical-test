package com.technical.test.hospital.quote.application.create;

import com.technical.test.hospital.quote.application.QuoteMapper;
import com.technical.test.hospital.quote.application.dto.QuoteRequestDto;
import com.technical.test.hospital.quote.domain.QuoteDomain;
import com.technical.test.hospital.quote.domain.QuoteRepository;
import org.springframework.stereotype.Component;

@Component
public class QuoteCreateCommandHandler {

    private final QuoteRepository quoteRepository;

    public QuoteCreateCommandHandler(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void handler(QuoteRequestDto quoteRequestDto) {
        final QuoteDomain quoteDomain = QuoteMapper.toDomain(quoteRequestDto);
        this.quoteRepository.create(quoteDomain);
    }
}
