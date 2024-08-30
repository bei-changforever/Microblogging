package com.example.Microblogging.services;


import com.example.Microblogging.dao.UserRepository;
import com.example.Microblogging.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserAccount save(UserAccount userAccount) {return userRepository.save(userAccount);}

    public List<UserAccount> getAll() {return userRepository.findAll();
    }

    public UserAccount findByUserId(long theId) {return userRepository.findByUserId(theId);}


    public void deleteByUserId(Long id) {
        UserAccount byId = userRepository.findByuserId(id);
        userRepository.delete(byId);
    }
}
