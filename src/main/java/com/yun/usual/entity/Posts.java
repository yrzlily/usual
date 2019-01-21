package com.yun.usual.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

/**
 * @author yrz
 */
@Entity
@Table(name = "us_posts")
@Data
public class Posts {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer user_id;

    @Column(insertable = false, columnDefinition = "")
    private String title;

    private Integer classify_id;

    private String content;

    @Column(insertable = false, columnDefinition = "0")
    private Integer start;

    @Column(insertable = false, columnDefinition = "0")
    private Integer pageview;

    @Column(insertable = false, columnDefinition = "0")
    private Integer status;

    private String create_time;

    private String update_time;

    private String audit_time;

    @JoinColumn(name="classify_id",referencedColumnName="id",nullable=false,updatable = false, insertable = false)
    @OneToOne
    private Classify classify;

    @JoinColumn(name = "posts_id", referencedColumnName = "id",nullable=false,updatable = false, insertable = false)
    @OneToMany(fetch = FetchType.EAGER)
    private List<Image> img;

    @JoinColumn(name = "user_id", referencedColumnName = "id",nullable=false,updatable = false, insertable = false)
    @OneToOne
    @NotFound(action= NotFoundAction.IGNORE)
    private User user;
}
