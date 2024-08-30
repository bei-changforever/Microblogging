package com.example.Microblogging.controller;

import com.example.Microblogging.dao.UserRepository;
import com.example.Microblogging.entity.UserAccount;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/topush")
    public String topush(){
        return "head/push";
    }

    @GetMapping("/login")
    public String displayUserForm(){
        return "security/login";
    }

    @GetMapping("/attention")
    public String attention() {
        return "head/attention";
    }


    @GetMapping("/toindexafter")
    public String toindexafter(){ return "head/index-after"; }

    @GetMapping("/mymessage")
    public String mymessage() {
        return "head/mymessage";
    }

    @GetMapping("/img")
    public String img() {
        return "text";
    }


    @GetMapping("/portrait")
    public  String portrait() {
        return "head/portrait";
    }

    @GetMapping("/tousermessage")
    public String tousermessage(Model model , UserAccount userAccount, Principal principal) throws JsonProcessingException{
        UserAccount userAccountByName = userRepository.findUserAccountByName(principal.getName());
        model.addAttribute("userAccount",userAccountByName);
        return "head/usermessage"; }


}
