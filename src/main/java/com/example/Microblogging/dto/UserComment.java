package com.example.Microblogging.dto;

import java.util.Date;

public interface UserComment {
    Long getCommentId();
    String getCommenter();

    String getCommentInfo();
    Long getUserId();

    Date getCommentTime();
    String getUsername();
}
