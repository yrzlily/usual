package com.yun.usual.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yrz
 */
@Entity
@Table(name = "us_admin_user")
@Data
public class AdminUser {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "admin_username")
    private String adminUsername;

    @Column(name = "admin_password")
    private String adminPassword;
}
