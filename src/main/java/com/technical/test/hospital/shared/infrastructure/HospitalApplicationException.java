package com.technical.test.hospital.shared.infrastructure;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class HospitalApplicationException extends RuntimeException {

    private String message;
    private HttpStatus statusCode;

    public HospitalApplicationException(String message, HttpStatus statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }
}
