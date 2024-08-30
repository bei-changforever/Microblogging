package com.example.Microblogging.dao;

import com.example.Microblogging.dto.UserComment;
import com.example.Microblogging.entity.Comment;
import com.example.Microblogging.entity.Many;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManyRepository extends CrudRepository<Many,Long> {

    @Override
    public List<Many> findAll();



}
