package com.dudii.tz.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "doctors")
//@NoArgsConstructor
//@Data
public class Doctor {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="kaugen" , strategy="increment")
    @GeneratedValue(generator="kaugen")
    private long id;

    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Comment> comment;

    public Doctor(){}

//    public Doctor(long id, @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?",
//            message = "Must start with a capital letter followed by one or more lowercase letters") String firstName, @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?",
//            message = "Must start with a capital letter followed by one or more lowercase letters") String lastName, List<Comment> comment) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.comment = comment;
//    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

//    public List<Comment> getComment() {
//        return comment;
//    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return id == doctor.id && Objects.equals(firstName, doctor.firstName) && Objects.equals(lastName, doctor.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
