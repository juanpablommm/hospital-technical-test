package com.technical.test.hospital.quote.api;

import com.technical.test.hospital.quote.application.cancel.QuoteCancelCommandHandler;
import com.technical.test.hospital.quote.application.create.QuoteCreateCommandHandler;
import com.technical.test.hospital.quote.application.dto.QuoteRequestDto;
import com.technical.test.hospital.quote.application.dto.QuoteResponseDto;
import com.technical.test.hospital.quote.application.find.QuoteFindByUserCommandHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/quote")
public class QuoteController {

    private final QuoteCreateCommandHandler quoteCreateCommandHandler;
    private final QuoteFindByUserCommandHandler quoteFindByUserCommandHandler;
    private final QuoteCancelCommandHandler quoteCancelCommandHandler;

    public QuoteController(QuoteCreateCommandHandler quoteCreateCommandHandler, QuoteFindByUserCommandHandler quoteFindByUserCommandHandler, QuoteCancelCommandHandler quoteCancelCommandHandler) {
        this.quoteCreateCommandHandler = quoteCreateCommandHandler;
        this.quoteFindByUserCommandHandler = quoteFindByUserCommandHandler;
        this.quoteCancelCommandHandler = quoteCancelCommandHandler;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody QuoteRequestDto quoteRequestDto) {
        this.quoteCreateCommandHandler.handler(quoteRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Quote has been created successfully");
    }

    @GetMapping(path = "/find/user")
    public ResponseEntity<Set<QuoteResponseDto>> create() {
        final Set<QuoteResponseDto> setQuoteResponseDto = this.quoteFindByUserCommandHandler.handler();
        return ResponseEntity.ok(setQuoteResponseDto);
    }

    @PutMapping(path = "/cancel/{codeQuote}")
    public ResponseEntity<String> cancel(@PathVariable String codeQuote) {
        this.quoteCancelCommandHandler.handler(Long.parseLong(codeQuote));
        return ResponseEntity.ok("The appointment has been cancelled");
    }
}
