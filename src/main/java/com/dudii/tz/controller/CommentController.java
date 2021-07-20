package com.dudii.tz.controller;

import com.dudii.tz.model.Comment;
import com.dudii.tz.repository.CommentRepository;
import com.dudii.tz.repository.DoctorRepository;
import com.dudii.tz.repository.PatientRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    private final CommentRepository commentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public CommentController(CommentRepository commentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.commentRepository = commentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

//    @GetMapping("/comments")
//    public List<Comment> getComments(){
//        return (List<Comment>) commentRepository.findAll();
//    }

    @PostMapping("patients/detail/{patient_id}/comments")
    public void addComment(@RequestBody Comment comment, @Param("patient_id") Long patient_id){
//        System.out.println("new");
//        System.out.println(patient_id);
//        System.out.println("---------");
//        System.out.println(comment);
        comment.setDateCreating(LocalDateTime.now());
        comment.setPatient(patientRepository.findById(comment.getPatient().getId()).get());
        comment.setDoctor(doctorRepository.findById(comment.getDoctor().getId()).get());
//        System.out.println(comment);
        commentRepository.save(comment);
    }

    @PutMapping("patients/detail/{patient_id}/comments")
    public void updateCommentById(@RequestBody Comment comment){
       Comment oldComment = commentRepository.findById(comment.getId()).orElse(null);
        if(oldComment != null){
            oldComment.setDoctor(comment.getDoctor());
            oldComment.setText(comment.getText());
            commentRepository.save(oldComment);
        }
    }

    @GetMapping("patients/detail/{patient_id}/comments")
    public List<Comment> getAllByPatientId (@PathVariable(name = "patient_id") Long patient_id){
        return commentRepository.getAllByPatientId(patient_id);
    }

    @GetMapping("patients/detail/comments/available_id")
    public Long getAvailableId (){
        return commentRepository.findMaxId() + 1;
    }


}
