package com.yun.usual.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

/**
 * @author yrz
 */
@Data
@Entity
@DynamicInsert
@Table(name = "us_category")
public class Category {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @Column(name = "parent_id")
    private Integer parentId;

    private Integer sort;

}
