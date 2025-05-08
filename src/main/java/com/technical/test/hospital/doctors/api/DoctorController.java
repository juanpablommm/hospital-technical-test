package com.technical.test.hospital.doctors.api;

import com.technical.test.hospital.doctors.application.CreateDockerCommandHandler;
import com.technical.test.hospital.doctors.application.DoctorRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "doctor")
@AllArgsConstructor
public class DoctorController {

    private CreateDockerCommandHandler createDockerCommandHandler;

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody DoctorRequestDto doctorRequestDto) {
        this.createDockerCommandHandler.handler(doctorRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Successfully created...");
    }
}
