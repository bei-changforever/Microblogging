package com.example.Microblogging.dao;

import com.example.Microblogging.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {
    List<Post> getFollowPosts(Integer userId);
}
