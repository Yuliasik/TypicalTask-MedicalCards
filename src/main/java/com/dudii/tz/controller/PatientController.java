package com.dudii.tz.controller;

import com.dudii.tz.model.Patient;
import com.dudii.tz.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getAll();
    }

    @PostMapping("/patients")
    public long addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    @GetMapping("/patients/{patient_id}")
    public Patient getPatientById(@PathVariable(name = "patient_id") Long patient_id) {
        return patientService.getPatientById(patient_id);
    }

    @GetMapping("/patients/byname/{name}")
    public List<Patient> getPatientByName(@PathVariable(name = "name") String name) {
        return patientService.getPatientByTemplateName(name);
    }

    @DeleteMapping("/patients/{patient_id}")
    public void deletePatientById(@PathVariable(name = "patient_id") Long patient_id) {
        patientService.deletePatientById(patient_id);
    }

    @PutMapping("/patients")
    public void updatePatientById(@RequestBody Patient patient) {
        patientService.updatePatientById(patient);
    }
}
