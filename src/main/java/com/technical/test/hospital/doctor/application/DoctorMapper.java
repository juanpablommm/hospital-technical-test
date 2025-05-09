package com.technical.test.hospital.doctor.application;

import com.technical.test.hospital.doctor.application.dto.DoctorRequestDto;
import com.technical.test.hospital.doctor.application.dto.DoctorResponseDto;
import com.technical.test.hospital.doctor.domain.DoctorDomain;

public class DoctorMapper {

    public static DoctorDomain toDomain(DoctorRequestDto doctorRequestDto){
        return new DoctorDomain(doctorRequestDto.fullName(), doctorRequestDto.speciality());
    }

    public static DoctorResponseDto toResponseDto(DoctorDomain doctorDomain){
        return new DoctorResponseDto(doctorDomain.getFullName(), doctorDomain.getSpecialty());
    }
}
