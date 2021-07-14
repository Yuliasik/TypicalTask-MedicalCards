package com.dudii.tz.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "date_creating", nullable = false)
    private LocalDateTime dateCreating;

    @NotBlank
    @Column(columnDefinition="TEXT")
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
