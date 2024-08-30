package com.example.Microblogging.services;

import com.example.Microblogging.dao.CommentRepository;
import com.example.Microblogging.dto.UserComment;
import com.example.Microblogging.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> getAll(){
        return commentRepository.findAll();
    }

    public List<UserComment> selectComentByUserId(Long id){
        List<UserComment> userComments = commentRepository.selectComentByUserId(id);
        return userComments;
    }

}
