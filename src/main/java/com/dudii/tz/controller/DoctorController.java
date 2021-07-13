package com.dudii.tz.controller;

import com.dudii.tz.model.Comment;
import com.dudii.tz.model.Doctor;
import com.dudii.tz.repository.CommentRepository;
import com.dudii.tz.repository.DoctorRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {
    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @GetMapping("/doctors")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
    }
}