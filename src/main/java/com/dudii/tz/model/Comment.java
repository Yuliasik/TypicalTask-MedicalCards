package com.dudii.tz.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private LocalDateTime dateCreating;

    @NotBlank
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;



}
