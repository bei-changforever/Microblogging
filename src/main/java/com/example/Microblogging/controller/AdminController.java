package com.example.Microblogging.controller;

import com.example.Microblogging.entity.UserAccount;
import com.example.Microblogging.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("/admin")
    public String displayadmin( Model model) {
        List<UserAccount> all = userService.getAll();
        model.addAttribute("userAccount",all);
        return "security/admin";
    }


    @GetMapping("userCRUD/{userId}")
    public String deleteEmployee(@PathVariable("userId") Long id ){
        userService.deleteByUserId(id);
        return  "redirect:/admin";
    }
}
