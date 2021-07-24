package com.dudii.tz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Patient {

    @Id
    @GenericGenerator(name = "kaugen", strategy = "increment")
    @GeneratedValue(generator = "kaugen")
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
    @Pattern(regexp = "[A-Z](([A-Z]+)|([a-z])+)([ -][A-Z](([A-Z]+)|([a-z])+))*",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    private String country;

    @NotBlank
    @Pattern(regexp = "[A-Z](([A-Z]+)|([a-z])+)([ -][A-Z](([A-Z]+)|([a-z])+))*",
            message = "Must start with a capital letter followed by one or more lowercase letters")
    private String state;

    @NotBlank
    private String address;

    @NotNull
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private List<Comment> comments = new ArrayList<>();
}
