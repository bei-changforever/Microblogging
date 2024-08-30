package com.example.Microblogging.dao;

import com.example.Microblogging.dto.UserComment;
import com.example.Microblogging.entity.Comment;
import com.example.Microblogging.entity.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {

    @Override
    public List<Comment> findAll();

    @Query(value = "select c.comment_id as commentId , c.commenter , c.comment_info as commentInfo , c.comment_time as commentTime , c.user_id as userId , u.username from comment as c inner join user_account as u on u.user_id = ?1 " ,nativeQuery = true)
    List<UserComment> selectComentByUserId(Long id);

}
