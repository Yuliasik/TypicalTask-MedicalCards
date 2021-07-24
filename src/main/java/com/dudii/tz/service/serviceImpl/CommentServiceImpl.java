package com.dudii.tz.service.serviceImpl;

import com.dudii.tz.model.Comment;
import com.dudii.tz.repository.CommentRepository;
import com.dudii.tz.service.CommentService;
import com.dudii.tz.service.DoctorService;
import com.dudii.tz.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, DoctorService doctorService, PatientService patientService) {
        this.commentRepository = commentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @Override
    public Comment addComment(Comment comment) {
        comment.setDateCreating(LocalDateTime.now());
        comment.setPatient(patientService.getPatientById(comment.getPatient().getId()));
        comment.setDoctor(doctorService.getDoctorById(comment.getDoctor().getId()));
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void updateCommentById(Comment comment) {
        Comment oldComment = commentRepository.findById(comment.getId()).orElse(null);
        if(oldComment != null){
            oldComment.setDoctor(comment.getDoctor());
            oldComment.setText(comment.getText());
            commentRepository.save(oldComment);
        }
    }

    @Override
    public List<Comment> getAllByPatientId(long patientId) {
        return commentRepository.findAllByPatient_IdEqualsOrderByDateCreatingAsc(patientId);
    }

}
