package com.dudii.tz.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "patient")
    private List<Comment> comments;
}
