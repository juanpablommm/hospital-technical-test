package com.technical.test.hospital.doctor.infrastructure;

public enum SpecialityEnum {

	DERMATOLOGIA("DERMATOLOGIA"),
    GINECOLOGIA("GINECOLOGÍA"),
    ODONTOLOGIA("ODONTOLOGÍA"),
    OTORRINOLARINGOLOGIA("OTORRINOLARINGOLOGÍA"),
    MEDICO_GENERAL("MEDICO GENERAL"),
    PEDIATRIA("PEDIATRIA");

    private final String speciality;

    SpecialityEnum(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }
}
