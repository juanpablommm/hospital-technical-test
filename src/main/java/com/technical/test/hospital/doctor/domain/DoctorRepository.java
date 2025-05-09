package com.technical.test.hospital.doctor.domain;

import java.util.Set;

public interface DoctorRepository {

    void create(DoctorDomain doctorDomain);

    Set<DoctorDomain> findAll();

}
