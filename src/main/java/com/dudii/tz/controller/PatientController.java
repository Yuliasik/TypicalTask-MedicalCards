package com.dudii.tz.controller;

import com.dudii.tz.model.Patient;
import com.dudii.tz.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return (List<Patient>) patientRepository.findAll();
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient){
        patientRepository.save(patient);
    }

    @GetMapping("/patient/{pation_id}")
    public Patient getPatientById(@PathVariable(name = "pation_id") Long pation_id){
         return patientRepository.findById(pation_id).orElse(null);
    }

    @GetMapping("/patient/{pation_id}/delete")
    public void deletePatientById(@PathVariable(name = "pation_id") Long pation_id){
        patientRepository.deleteById(pation_id);
    }

    @GetMapping("/patient/{pation_id}/update")
    public void updatePatientById(@RequestBody Patient patient){
        Patient oldPatient = patientRepository.findById(patient.getId()).orElse(null);
        if (oldPatient != null){
            oldPatient.setFirstName(patient.getFirstName());
            oldPatient.setLastName(patient.getLastName());
            oldPatient.setBirthday(patient.getBirthday());
            oldPatient.setCountry(patient.getCountry());
            oldPatient.setState(patient.getState());
            oldPatient.setAddress(patient.getAddress());
            oldPatient.setSex(patient.getSex());

            patientRepository.save(oldPatient);
        }
    }
}
