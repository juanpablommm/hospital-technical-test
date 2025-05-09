package com.technical.test.hospital.doctor.infrastructure;


import com.technical.test.hospital.doctor.domain.DoctorDomain;

public final class DoctorMapper {

    public static DoctorEntity toEntity(DoctorDomain doctorDomain) {
        final SpecialityEnum specialty = SpecialityEnum.valueOf(doctorDomain.getSpecialty());
        return DoctorEntity.builder()
                .fullName(doctorDomain.getFullName())
                .speciality(specialty)
                .build();
    }

    public static DoctorDomain toDomain(DoctorEntity doctorEntity) {
        final String speciality = doctorEntity.getSpeciality().getSpeciality();
        return new DoctorDomain(doctorEntity.getFullName(), speciality);
    }
}
