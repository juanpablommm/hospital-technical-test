package com.technical.test.hospital.quote.application.dto;

import com.technical.test.hospital.doctor.infrastructure.DoctorEntity;
import com.technical.test.hospital.users.infrastructure.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

public class QuoteResponseDto {

    private String date;
    private String startTime;
    private String endTime;
    private Boolean isCancel;
    private String description;
    private String doctor;

    public QuoteResponseDto(String date, String startTime, String endTime, Boolean isCancel, String description, String doctor) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isCancel = isCancel;
        this.description = description;
        this.doctor = doctor;
    }

    public QuoteResponseDto() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getCancel() {
        return isCancel;
    }

    public void setCancel(Boolean cancel) {
        isCancel = cancel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
