package com.dudii.tz.repository;

import com.dudii.tz.model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

//    @Query("SELECT id, first_name, last_name, birthday FROM patients")
//    public List<Patient> getAllMainProperties(){
//
//    }
}
