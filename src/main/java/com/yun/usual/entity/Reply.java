package com.yun.usual.entity;

import com.yun.usual.dto.UserInfo;
import lombok.Data;

import javax.persistence.*;

/**
 * @author yrz
 */
@Entity
@Table(name = "us_reply")
@Data
public class Reply {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer posts_id;

    private Integer user_id;

    private String content;

    @Column(insertable = false, columnDefinition = "1")
    private Integer status;

    private String create_time;

    @OneToOne
    @JoinColumn(name = "user_id",columnDefinition = "id",nullable = false, insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "posts_id", columnDefinition = "id", nullable = false, insertable = false, updatable = false)
    private Posts posts;
}
