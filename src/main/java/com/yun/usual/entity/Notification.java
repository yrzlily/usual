package com.yun.usual.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yrz
 */
@Entity
@Table(name = "us_notification")
@Data
public class Notification {

    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    private Integer status;

    private String create_time;
}
