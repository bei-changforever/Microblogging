package com.example.Microblogging.dao;

import com.example.Microblogging.entity.Reply;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository {
    List<Reply> getReplyByCommentId(Integer askId, Integer commentId);
}
