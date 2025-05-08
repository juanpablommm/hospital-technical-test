package com.technical.test.hospital.doctors.infraestrcuture;

public enum SpecialityEnum {

	DERMATOLOGIA("DERMATOLOGIA"),
    GINECOLOGIA("GINECOLOGÍA"),
    ODONTOLOGIA("ODONTOLOGÍA"),
    OTORRINOLARINGOLOGÍA("OTORRINOLARINGOLOGÍA");

    private final String speciality;

    SpecialityEnum(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }
}
