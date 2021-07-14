package com.dudii.tz.controller;

import com.dudii.tz.model.Doctor;
import com.dudii.tz.repository.DoctorRepository;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/doctors")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
    }
}