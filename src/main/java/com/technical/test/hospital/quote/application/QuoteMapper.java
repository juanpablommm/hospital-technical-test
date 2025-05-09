package com.technical.test.hospital.quote.application;

import com.technical.test.hospital.quote.application.dto.QuoteRequestDto;
import com.technical.test.hospital.quote.application.dto.QuoteResponseDto;
import com.technical.test.hospital.quote.domain.QuoteDomain;
import com.technical.test.hospital.quote.infraestructure.QuoteEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public final class QuoteMapper {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("H:mm");

    public static QuoteResponseDto toResponseDto(QuoteDomain quoteDomain) {
        return new QuoteResponseDto(
                formatDate(quoteDomain.date()),
                formatTime(quoteDomain.startTime()),
                formatTime(quoteDomain.endTime()),
                quoteDomain.isCancel(),
                quoteDomain.description(),
                quoteDomain.doctor()
        );
    }


    public static QuoteDomain toDomain(QuoteRequestDto quoteRequestDto) {
        return new QuoteDomain(parseOffsetDateTime(quoteRequestDto.date()),
                parseOffsetTime(quoteRequestDto.hour()),
                calculateEndTime(quoteRequestDto.hour()),
                quoteRequestDto.description(), quoteRequestDto.doctor(), quoteRequestDto.user(), false);
    }

    private static OffsetDateTime parseOffsetDateTime(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, DATE_FORMATTER);
        return date.atStartOfDay(ZoneOffset.UTC).toOffsetDateTime();
    }

    private static OffsetTime parseOffsetTime(String timeStr) {
        LocalTime time = LocalTime.parse(timeStr, TIME_FORMATTER);
        return time.atOffset(ZoneOffset.UTC);
    }

    private static OffsetTime calculateEndTime(String startTimeStr) {
        OffsetTime startTime = parseOffsetTime(startTimeStr);
        return startTime.plusMinutes(30);
    }

    private static String formatDate(OffsetDateTime date) {
        return date.format(DATE_FORMATTER);
    }

    private static String formatTime(OffsetTime time) {
        return time.format(TIME_FORMATTER);
    }
}
