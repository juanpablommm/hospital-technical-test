package com.technical.test.hospital.doctors.infraestrcuture;


import com.technical.test.hospital.doctors.domain.DoctorDomain;

public final class DoctorMapper {

    public static DoctorsEntity toEntity(DoctorDomain doctorDomain) {
        final SpecialityEnum specialty = SpecialityEnum.valueOf(doctorDomain.getSpecialty());
        final DoctorsEntity doctorsEntity = new DoctorsEntity();
        doctorsEntity.setFullName(doctorDomain.getFullName());
        doctorsEntity.setSpecialty(specialty);
        return doctorsEntity;
    }
}
