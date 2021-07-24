package com.dudii.tz.repository;

import com.dudii.tz.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByPatient_IdEqualsOrderByDateCreatingAsc (@Param("patient_id") long patientId);

    @Query("SELECT MAX(comment.id) FROM Comment comment")
    Long findMaxId();
}
