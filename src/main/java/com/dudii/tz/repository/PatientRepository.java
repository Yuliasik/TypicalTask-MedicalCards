package com.dudii.tz.repository;

import com.dudii.tz.model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    public List<Patient> findAllByFirstNameIsContainingIgnoreCaseOrLastNameContainingIgnoreCase(String infixFirstName, String infixLastName);
}
