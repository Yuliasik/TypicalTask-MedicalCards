package com.dudii.tz.service;

import com.dudii.tz.model.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);

    void updateCommentById(Comment comment);

    List<Comment> getAllByPatientId(long patientId);
    
}
