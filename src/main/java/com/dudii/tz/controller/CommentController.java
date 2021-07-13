package com.dudii.tz.controller;

import com.dudii.tz.model.Comment;
import com.dudii.tz.repository.CommentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/comments")
    public List<Comment> getComments(){
        return (List<Comment>) commentRepository.findAll();
    }

    @GetMapping("/comments")
    public void addComment(@RequestBody Comment comment){
        comment.setDateCreating(LocalDateTime.now());
        commentRepository.save(comment);
    }

    @GetMapping("/comment/{comment_id}/update")
    public void updateCommentById(@RequestBody Comment comment){
        Comment oldComment = commentRepository.findById(comment.getId()).orElse(null);
        if(oldComment != null){
            oldComment.setDoctor(comment.getDoctor());
            oldComment.setText(comment.getText());

            commentRepository.save(oldComment);
        }
    }

}
