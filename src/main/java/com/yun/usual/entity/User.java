package com.yun.usual.entity;

import lombok.Data;
import org.bouncycastle.jcajce.provider.digest.MD5;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.DigestUtils;

import javax.persistence.*;

/**
 * @author yrz
 */
@Entity
@Table(name = "us_user")
@DynamicUpdate
@Data
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(insertable = false, columnDefinition = "")
    private String username;

    private String openid;

    private String nickname;

    private Integer gender;

    private String city;

    private String avatar;

    private String create_time;

    @Column(insertable = false)
    private Integer status;

    @Column(insertable = false)
    private Integer group_id;

    @Transient
    private String token;


}
