package com.dudii.tz.repository;

import com.dudii.tz.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    @Query("SELECT comment " +
            "FROM Comment comment " +
            "WHERE comment.patient.id =:patient_id " +
            "ORDER BY comment.dateCreating ASC")
    List<Comment> getAllByPatientId (@Param("patient_id") long patientId);

    @Query("SELECT MAX(comment.id) FROM Comment comment")
    Long findMaxId();
}
