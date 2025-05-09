package com.technical.test.hospital.doctor.application.create;

import com.technical.test.hospital.doctor.application.DoctorMapper;
import com.technical.test.hospital.doctor.application.dto.DoctorRequestDto;
import com.technical.test.hospital.doctor.domain.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateDoctorCommandHandler {

    private DoctorRepository doctorRepository;

    public void handler(DoctorRequestDto doctorRequestDto) {
        this.doctorRepository.create(DoctorMapper.toDomain(doctorRequestDto));
    }
}
