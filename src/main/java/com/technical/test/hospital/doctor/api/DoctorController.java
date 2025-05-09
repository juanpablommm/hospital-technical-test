package com.technical.test.hospital.doctor.api;

import com.technical.test.hospital.doctor.application.create.CreateDoctorCommandHandler;
import com.technical.test.hospital.doctor.application.dto.DoctorRequestDto;
import com.technical.test.hospital.doctor.application.dto.DoctorResponseDto;
import com.technical.test.hospital.doctor.application.find.FindDoctorCommandHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "doctor")
public class DoctorController {

    private final CreateDoctorCommandHandler createDoctorCommandHandler;
    private final FindDoctorCommandHandler findDoctorCommandHandler;

    public DoctorController(CreateDoctorCommandHandler createDoctorCommandHandler, FindDoctorCommandHandler findDoctorCommandHandler) {
        this.createDoctorCommandHandler = createDoctorCommandHandler;
        this.findDoctorCommandHandler = findDoctorCommandHandler;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> create(@RequestBody @Valid DoctorRequestDto doctorRequestDto) {
        this.createDoctorCommandHandler.handler(doctorRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("The doctor has been registered successfully");
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<Set<DoctorResponseDto>> findAll() {
        final Set<DoctorResponseDto> setDoctorResponseDto = this.findDoctorCommandHandler.handler();
        return ResponseEntity.ok(setDoctorResponseDto);
    }
}
