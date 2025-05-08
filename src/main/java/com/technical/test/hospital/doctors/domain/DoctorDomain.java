package com.technical.test.hospital.doctors.domain;

public class DoctorDomain {

    private String fullName;

    private String specialty;

    public DoctorDomain(String fullName, String specialty) {
        this.fullName = fullName;
        this.specialty = specialty;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
