package com.technical.test.hospital.qoutes.infraestructure;

import com.technical.test.hospital.doctors.infraestrcuture.DoctorsEntity;
import com.technical.test.hospital.users.infraestructure.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;

@Table(name = "quote")
@Entity
public class QuotesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "is_cancel")
    private Boolean isCancel;

    @Column(name = "date")
    private OffsetDateTime date;

    @OneToOne()
    @JoinColumn(name = "id_user")
    private UserEntity user;

    @OneToOne()
    @JoinColumn(name = "id_doctor")
    private DoctorsEntity docker;
}
