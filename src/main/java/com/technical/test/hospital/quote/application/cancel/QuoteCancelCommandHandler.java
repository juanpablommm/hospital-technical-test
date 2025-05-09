package com.technical.test.hospital.quote.application.cancel;

import com.technical.test.hospital.quote.domain.QuoteRepository;
import org.springframework.stereotype.Component;

@Component
public class QuoteCancelCommandHandler {

    private final QuoteRepository quoteRepository;

    public QuoteCancelCommandHandler(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public void handler(Long quoteId) {
        this.quoteRepository.cancelQuote(quoteId);
    }
}
