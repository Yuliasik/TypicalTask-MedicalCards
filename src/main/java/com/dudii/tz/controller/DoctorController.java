package com.dudii.tz.controller;

import com.dudii.tz.model.Doctor;
import com.dudii.tz.model.Patient;
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
        System.out.println(doctor);
        doctorRepository.save(doctor);
    }

    @GetMapping("/doctors/{doctor_id}")
    public Doctor getDoctorById(@PathVariable(name = "doctor_id") Long doctor_id){
        return doctorRepository.findById(doctor_id).orElse(null);
    }
}