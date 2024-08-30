package com.example.Microblogging.dao;

import com.example.Microblogging.entity.UserAccount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<UserAccount , Long> {
    @Override
    public List<UserAccount> findAll();



    @Query(value = "select * from user_account where username=:name" ,nativeQuery = true)
    UserAccount findUserAccountByName(String name);
    
    @Query(value = "select * from user_account where user_id = ?1 " ,nativeQuery = true)
    UserAccount findByUserId(long theId);

    UserAccount findByuserId(Long id);
}
