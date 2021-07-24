package com.dudii.tz.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Comment {

    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
    private long id;

    @NotNull
    @Column(name = "date_creating", nullable = false)
    private LocalDateTime dateCreating;

    @NotBlank
    @Column(columnDefinition = "TEXT")
    private String text;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_doctor")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Doctor doctor;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_patient")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Patient patient;
}
