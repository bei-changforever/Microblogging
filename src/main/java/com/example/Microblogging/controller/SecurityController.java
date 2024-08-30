package com.example.Microblogging.controller;


import com.example.Microblogging.dao.UserRepository;
import com.example.Microblogging.entity.UserAccount;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class SecurityController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/toregister")
    public String register(Model model){
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);
        return "security/register";
    }

    @PostMapping("/register/save")
    public String save(Model model ,UserAccount userAccount){
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        userRepository.save(userAccount);
        return "redirect:/";
    }

    @GetMapping("/tologin")
    public String displayUserForm(Model model){
        List<UserAccount> userAccounts = userRepository.findAll();
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);
        return "security/login";
    }

    @GetMapping("/forget")
    public String forget(){
        return "security/forget";
    }


}
