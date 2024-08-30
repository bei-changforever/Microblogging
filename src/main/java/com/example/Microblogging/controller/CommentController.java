package com.example.Microblogging.controller;

import com.example.Microblogging.dao.CommentRepository;
import com.example.Microblogging.dao.UserRepository;
import com.example.Microblogging.dto.UserComment;
import com.example.Microblogging.entity.Comment;
import com.example.Microblogging.entity.UserAccount;
import com.example.Microblogging.services.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class CommentController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentService commentService;

    @GetMapping
    public String DisplayComments(Model model){
        List<Comment> comments = commentService.getAll();
        Comment aComment = new Comment();
        model.addAttribute("comment",aComment);
        return "head/comment";
    }


    @GetMapping("/tocomment")
    public String tocomment(Model model , UserAccount userAccount,  Principal principal) throws JsonProcessingException {
        UserAccount userAccountByName = userRepository.findUserAccountByName(principal.getName());
        model.addAttribute("userAccount",userAccountByName);

        List<UserComment> userComments = commentService.selectComentByUserId(userAccountByName.getUserId());
        model.addAttribute("userComments",userComments);

        return "head/comment";
    }

    @PostMapping("/comment/save")
    public String CreateComment(Model model, @RequestParam(name = "story") String commentInfo , Principal principal){
        Comment comment1 = new Comment();
        UserAccount userAccountByName = userRepository.findUserAccountByName(principal.getName());
        comment1.setUserAccount(userAccountByName);
        comment1.setComment_info(commentInfo);
        commentService.save(comment1);
        return "redirect:/tocomment";
    }
}
