package com.yun.usual.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yrz
 */
@Data
@Entity
@Table(name = "us_image")
public class Image {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String src;

    private Long size;

    private Integer posts_id = 0;

    private String create_time;

    private String type = "";


}
