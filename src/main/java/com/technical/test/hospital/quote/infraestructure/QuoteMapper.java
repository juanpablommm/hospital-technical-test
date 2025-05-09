package com.technical.test.hospital.quote.infraestructure;


import com.technical.test.hospital.quote.domain.QuoteDomain;

public final class QuoteMapper {

	public static QuoteDomain toDomain(QuoteEntity quoteEntity) {
		final String doctor = quoteEntity.getDoctor().getFullName();
		final String user = quoteEntity.getUser().getFullName();
		return new QuoteDomain(quoteEntity.getDate(), quoteEntity.getStartTime(),
				quoteEntity.getEndTime(), quoteEntity.getDescription(), doctor, user, quoteEntity.getIsCancel());
	}

	public static QuoteEntity toEntity(QuoteDomain quoteDomain) {
		return QuoteEntity.builder()
				.date(quoteDomain.date())
				.startTime(quoteDomain.startTime())
				.endTime(quoteDomain.endTime())
				.description(quoteDomain.description())
				.isCancel(quoteDomain.isCancel())
				.build();
	}
}
