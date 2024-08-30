package com.example.Microblogging.entity;

import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "many")
public class Many {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manyId;

    private String  jpeg ;// 影视图片

    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "user_id")
    private UserAccount userAccount ;




    public Many(){

    }

    public Many(Long manyId, String jpeg, UserAccount userAccount) {
        this.manyId = manyId;
        this.jpeg = jpeg;
        this.userAccount = userAccount;
    }

    public Long getManyId() {
        return manyId;
    }

    public void setManyId(Long manyId) {
        this.manyId = manyId;
    }

    public String getJpeg() {
        return jpeg;
    }

    public void setJpeg(String jpeg) {
        this.jpeg = jpeg;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "Many{" +
                "manyId=" + manyId +
                ", jpeg='" + jpeg + '\'' +
                ", userAccount=" + userAccount +
                '}';
    }
}

