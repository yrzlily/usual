package com.yun.usual.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author yrz
 */
@Entity
@Data
@Table(name = "us_admin_nav")
public class AdminNav {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "nav_name")
    private String navName;

    @Column(name = "nav_parent_id")
    private Integer navParentId;

    @Column(name = "sort")
    private Integer sort;

    private String url;

    private String icon;

    @Column(name = "create_time")
    private String createTime;

    @Transient
    private List<AdminNav> nav;

}
