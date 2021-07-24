package com.dudii.tz.controller;

import com.dudii.tz.model.Comment;
import com.dudii.tz.repository.CommentRepository;
import com.dudii.tz.repository.DoctorRepository;
import com.dudii.tz.repository.PatientRepository;
import com.dudii.tz.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments/add")
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PutMapping("/comments/update")
    public void updateCommentById(@RequestBody Comment comment) {
        commentService.updateCommentById(comment);
    }

    @GetMapping("patients/detail/{patient_id}/comments")
    public List<Comment> getAllByPatientId(@PathVariable(name = "patient_id") Long patient_id) {
        return commentService.getAllByPatientId(patient_id);
    }

}
