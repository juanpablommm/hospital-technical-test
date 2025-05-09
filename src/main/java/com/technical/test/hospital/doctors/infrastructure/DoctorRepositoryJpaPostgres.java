package com.technical.test.hospital.doctors.infraestrcuture;

import com.technical.test.hospital.doctors.domain.DoctorDomain;
import com.technical.test.hospital.doctors.domain.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@AllArgsConstructor
public class DoctorRepositoryJpaPostgres implements DoctorRepository {

    private DoctorRepositoryJpa doctorRepositoryJpa;

    @Override
    public void create(DoctorDomain doctorDomain) {
        this.doctorRepositoryJpa.save(DoctorMapper.toEntity(doctorDomain));
    }
}
