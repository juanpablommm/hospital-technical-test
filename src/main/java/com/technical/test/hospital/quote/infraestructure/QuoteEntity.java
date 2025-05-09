package com.technical.test.hospital.quote.infraestructure;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.technical.test.hospital.doctor.infrastructure.DoctorEntity;
import com.technical.test.hospital.users.infrastructure.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.time.OffsetTime;

@Entity
@Table(name = "quotes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private OffsetDateTime date;

    @Column(name = "start_time", columnDefinition = "TIME WITH TIME ZONE")
    private OffsetTime startTime;

    @Column(name = "end_time", columnDefinition = "TIME WITH TIME ZONE")
    private OffsetTime endTime;

    @Column(name = "is_cancel")
    private Boolean isCancel;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserEntity user;


    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "id_doctor", referencedColumnName = "id")
    private DoctorEntity doctor;
}