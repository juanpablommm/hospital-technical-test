package com.technical.test.hospital.doctor.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepositoryJpa extends JpaRepository<DoctorEntity, Integer> {

    Optional<DoctorEntity> findByFullName(String fullName);
}
