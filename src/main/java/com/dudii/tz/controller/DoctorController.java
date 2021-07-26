package com.dudii.tz.controller;

import com.dudii.tz.model.Doctor;
import com.dudii.tz.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors() {
        return doctorService.getDoctors();
    }

    @PostMapping("/doctors")
    public void addDoctor(@RequestBody Doctor doctor) {
        doctorService.addDoctor(doctor);
    }

    @GetMapping("/doctors/{doctor_id}")
    public Doctor getDoctorById(@PathVariable(name = "doctor_id") Long doctor_id) {
        return doctorService.getDoctorById(doctor_id);
    }
}