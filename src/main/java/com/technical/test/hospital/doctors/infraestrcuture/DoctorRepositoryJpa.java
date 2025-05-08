package com.technical.test.hospital.doctors.infraestrcuture;

import com.technical.test.hospital.doctors.domain.DoctorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepositoryJpa extends JpaRepository<DoctorsEntity, Integer> {

}
