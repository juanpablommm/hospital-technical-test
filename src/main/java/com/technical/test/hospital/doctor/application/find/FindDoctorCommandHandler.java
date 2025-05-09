package com.technical.test.hospital.doctor.application.find;

import com.technical.test.hospital.doctor.application.DoctorMapper;
import com.technical.test.hospital.doctor.application.dto.DoctorResponseDto;
import com.technical.test.hospital.doctor.domain.DoctorRepository;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FindDoctorCommandHandler {

    private final DoctorRepository doctorRepository;

    public FindDoctorCommandHandler(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Set<DoctorResponseDto> handler() {
        return this.doctorRepository.findAll().stream()
                .map(DoctorMapper::toResponseDto)
                .collect(Collectors.toSet());
    }
}
