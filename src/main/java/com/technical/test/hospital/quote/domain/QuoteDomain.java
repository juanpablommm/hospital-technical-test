package com.technical.test.hospital.quote.domain;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

public record QuoteDomain(OffsetDateTime date, OffsetTime startTime, OffsetTime endTime,
                          String description, String doctor, String user, boolean isCancel) { }
