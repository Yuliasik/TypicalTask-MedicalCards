package com.dudii.tz.service;

import com.dudii.tz.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAll();

    long addPatient(Patient patient);

    Patient getPatientById(long patientId);

    List<Patient> getPatientByTemplateName(String name);

    void deletePatientById(long patientId);

    void updatePatientById(Patient patient);

}
