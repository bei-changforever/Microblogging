package com.example.Microblogging.controller;

import com.example.Microblogging.dao.ManyRepository;
import com.example.Microblogging.dao.UserRepository;
import com.example.Microblogging.entity.Many;
import com.example.Microblogging.entity.UserAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
public class ManyController {

    @Autowired
    ManyRepository manyRepository;

    @GetMapping("/tomany")
    public String tomany(Model model){
        List<Many> all = manyRepository.findAll();
        model.addAttribute("many",all);
        return "head/many";
    }



}
