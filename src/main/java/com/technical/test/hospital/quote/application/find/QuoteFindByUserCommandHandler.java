package com.technical.test.hospital.quote.application.find;

import com.technical.test.hospital.quote.application.QuoteMapper;
import com.technical.test.hospital.quote.application.dto.QuoteRequestDto;
import com.technical.test.hospital.quote.application.dto.QuoteResponseDto;
import com.technical.test.hospital.quote.domain.QuoteRepository;
import com.technical.test.hospital.shared.infrastructure.HospitalApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class QuoteFindByUserCommandHandler {

    private final QuoteRepository quoteRepository;

    public QuoteFindByUserCommandHandler(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Set<QuoteResponseDto> handler() {
        final Set<QuoteResponseDto> setQuoteResponseDto = this.quoteRepository.findQuoteByUser().stream()
                .map(QuoteMapper::toResponseDto)
                .collect(Collectors.toSet());

        if (setQuoteResponseDto.isEmpty())
            throw new HospitalApplicationException("No appointment found in the system", HttpStatus.NOT_FOUND);

        return setQuoteResponseDto;
    }
}
