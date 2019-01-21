package com.yun.usual.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yrz
 */
@Data
@Entity
@Table(name = "us_classify")
public class Classify {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String create_time;

    private String update_time;

    private Integer pid;

}
