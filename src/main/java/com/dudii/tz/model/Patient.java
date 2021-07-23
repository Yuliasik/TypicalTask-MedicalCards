package com.dudii.tz.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "patients")
//@NoArgsConstructor
//@Data
public class Patient {
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

    @NotNull
    private Date birthday;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+([\\s-][A-Z][a-z]+)?",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    private String country;

    @NotBlank
    @Pattern(regexp = "[A-Z][a-z]+([\\s-][A-Z][a-z]+)?",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    private String state;

    @NotBlank
    private String address;

    @NotNull
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @Getter(AccessLevel.PRIVATE)
//    @Setter(AccessLevel.PRIVATE)
    private List<Comment> comments;

    public Patient() { }

//    public Patient(long id, @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?",
//            message = "Must start with a capital letter followed by one or more lowercase letters") String firstName, @Pattern(regexp = "[A-Z][a-z]+(-[A-Z][a-z]+)?",
//            message = "Must start with a capital letter followed by one or more lowercase letters") String lastName, @NotNull Date birthday, @NotNull Sex sex, @NotBlank @Pattern(regexp = "[A-Z][a-z]+([\\s-][A-Z][a-z]+)?",
//            message = "Must start with a capital letter followed by one or more lowercase letters") String country, @NotBlank @Pattern(regexp = "[A-Z][a-z]+([\\s-][A-Z][a-z]+)?",
//            message = "Must start with a capital letter followed by one or more lowercase letters") String state, @NotBlank String address, @NotNull List<Comment> comments) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.birthday = birthday;
//        this.sex = sex;
//        this.country = country;
//        this.state = state;
//        this.address = address;
//        this.comments = comments;
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

    public Date getBirthday() {
        return birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

//    public List<Comment> getComments() {
//        return comments;
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(birthday, patient.birthday) && sex == patient.sex && Objects.equals(country, patient.country) && Objects.equals(state, patient.state) && Objects.equals(address, patient.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, sex, country, state, address);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
