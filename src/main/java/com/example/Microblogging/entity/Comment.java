package com.example.Microblogging.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;         //评论ID

    @Column(name = "commenter")
    private String commenter;    //评论人

    @Column(name = "comment_info")
    private String comment_info;     //评论信息

    @Column(name = "comment_time")
    private Date comment_time = new Date();       //评论时间

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;



    public UserAccount getUserAccount() {
        return userAccount;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commenter='" + commenter + '\'' +
                ", comment_info='" + comment_info + '\'' +
                ", comment_time=" + comment_time +
                ", userAccount=" + userAccount +
                '}';
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Comment(long commentId, String commenter, String comment_info, Date comment_time, UserAccount userAccount) {
        this.commentId = commentId;
        this.commenter = commenter;
        this.comment_info = comment_info;
        this.comment_time = comment_time;
        this.userAccount = userAccount;
    }

    public Comment(){

    }

    public Comment(String commenter, String comment_info, Date comment_time) {
        this.commenter = commenter;
        this.comment_info = comment_info;
        this.comment_time = comment_time;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }

    public String getComment_info() {
        return comment_info;
    }

    public void setComment_info(String comment_info) {
        this.comment_info = comment_info;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }
}
