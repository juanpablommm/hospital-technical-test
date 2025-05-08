package com.technical.test.hospital.doctors.application;

import com.technical.test.hospital.doctors.domain.DoctorDomain;

public class DockerMapperApi {

    public static DoctorDomain doctorDomain(DoctorRequestDto doctorRequestDto){
        return new DoctorDomain(doctorRequestDto.fullName(), doctorRequestDto.speciality());
    }
}
