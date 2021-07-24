package com.dudii.tz.service;

import com.dudii.tz.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctors();

    void addDoctor(Doctor doctor);

    Doctor getDoctorById(long doctorId);
}
