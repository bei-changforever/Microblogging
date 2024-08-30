package com.example.Microblogging.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "username")
    private String Username;

    private String role = "ROLE_USER";
    private String password;
    private String email;

    private boolean enabled = true;

    @OneToMany(mappedBy = "userAccount")
    private List<Comment> commentList;


    @OneToOne(mappedBy = "userAccount")
    private Many many ;



    public UserAccount(long userId, String username, String role, String password, String email, boolean enabled, List<Comment> commentList, Many many) {
        this.userId = userId;
        Username = username;
        this.role = role;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.commentList = commentList;
        this.many = many;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }


    public Many getMany() {
        return many;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", Username='" + Username + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", commentList=" + commentList +
                ", many=" + many +
                '}';
    }

    public void setMany(Many many) {
        this.many = many;
    }

    public UserAccount(){

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
