package com.dudii.tz.controller;

import com.dudii.tz.model.Patient;
import com.dudii.tz.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

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

    @GetMapping("/patients/{patient_id}")
    public Patient getPatientById(@PathVariable(name = "patient_id") Long patient_id){
         return patientRepository.findById(patient_id).orElse(null);
    }

    @GetMapping("/patients/byname/{name}")
    public List<Patient> getPatientByName(@PathVariable(name = "name") String name){
        return patientRepository.findAllByName(name.toUpperCase(Locale.ROOT));
    }

    @DeleteMapping("/patients/{patient_id}")
    public void deletePatientById(@PathVariable(name = "patient_id") Long patient_id){
//        int size = this.getPatients().size();
        patientRepository.deleteById(patient_id);
    }

    @PutMapping("/patients")
    public void updatePatientById(@RequestBody Patient patient){
        System.out.println(patient);
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
