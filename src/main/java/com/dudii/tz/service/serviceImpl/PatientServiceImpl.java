package com.dudii.tz.service.serviceImpl;

import com.dudii.tz.model.Patient;
import com.dudii.tz.repository.PatientRepository;
import com.dudii.tz.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public List<Patient> getAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public long addPatient(Patient patient) {
        patientRepository.save(patient);
        return patient.getId();
    }

    @Override
    public Patient getPatientById(long patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }

    @Override
    public List<Patient> getPatientByTemplateName(String name) {
        return patientRepository.findAllByFirstNameIsContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
    }

    @Override
    public void deletePatientById(long patientId) {
        patientRepository.deleteById(patientId);
    }

    @Override
    public void updatePatientById(Patient patient) {
        Patient oldPatient = patientRepository.findById(patient.getId()).orElse(null);
        if (oldPatient != null) {
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
