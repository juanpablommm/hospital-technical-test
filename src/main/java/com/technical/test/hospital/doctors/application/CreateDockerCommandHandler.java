package com.technical.test.hospital.doctors.application;

import com.technical.test.hospital.doctors.domain.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateDockerCommandHandler {

    private DoctorRepository doctorRepository;

    public void handler(DoctorRequestDto doctorRequestDto) {
        this.doctorRepository.create(DockerMapperApi.doctorDomain(doctorRequestDto));
    }
}
