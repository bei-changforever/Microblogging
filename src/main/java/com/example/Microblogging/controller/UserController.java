package com.example.Microblogging.controller;

import com.example.Microblogging.dao.UserRepository;
import com.example.Microblogging.entity.UserAccount;
import com.example.Microblogging.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String displayUserForm(Model model){
        List<UserAccount> userAccounts = userRepository.findAll();
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount",userAccount);
        return "head/index";
    }

    @PostMapping("/userAccount/save")
    public String UserSave(Model model ,UserAccount userAccount){
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        userRepository.save(userAccount);
        return "redirect:/";
    }


    @GetMapping("/update")
    public String displayUserUpdateForm(@RequestParam("id") long theId, Model model){
        UserAccount theUser = userService.findByUserId(theId);
        model.addAttribute("userAccount",theUser);
        return "head/usermessage";
    }
}

