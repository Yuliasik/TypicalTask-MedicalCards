package com.dudii.tz.repository;

import com.dudii.tz.model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    @Query("SELECT patient " +
            "FROM Patient patient " +
            "WHERE UPPER(patient.firstName) LIKE %:name% OR UPPER(patient.lastName) LIKE %:name%")
    public List<Patient> findAllByName(@Param("name") String name);
}
