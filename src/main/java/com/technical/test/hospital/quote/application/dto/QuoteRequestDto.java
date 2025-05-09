package com.technical.test.hospital.quote.application.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record QuoteRequestDto(
        @NotNull(message = "The date cannot be null")
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$",
                message = "La fecha debe tener el formato DD/MM/YYYY")
        String date,

        @NotNull(message = "The start time cannot be null")
        @Pattern(regexp = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$",
                message = "La hora debe tener el formato HH:MM")
        String hour,

        @NotBlank(message = "The description cannot be null")
        String description,

        @NotBlank(message = "The docker cannot be null")
        String doctor,

        @JsonIgnore
        String user
) {}