package com.dudii.tz.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "comments")
//@NoArgsConstructor
//@Data
public class Comment {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
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

    public Comment(){}

//    public Comment(long id, @NotNull LocalDateTime dateCreating, @NotBlank String text, @NotNull Doctor doctor, @NotNull Patient patient) {
//        this.id = id;
//        this.dateCreating = dateCreating;
//        this.text = text;
//        this.doctor = doctor;
//        this.patient = patient;
//    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDateCreating() {
        return dateCreating;
    }

    public String getText() {
        return text;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateCreating(LocalDateTime dateCreating) {
        this.dateCreating = dateCreating;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && Objects.equals(dateCreating, comment.dateCreating) && Objects.equals(text, comment.text) && Objects.equals(doctor, comment.doctor) && Objects.equals(patient, comment.patient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateCreating, text, doctor, patient);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", dateCreating=" + dateCreating +
                ", text='" + text + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
