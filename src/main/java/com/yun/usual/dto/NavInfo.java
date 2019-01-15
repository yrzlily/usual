package com.yun.usual.dto;

import lombok.Data;

import java.util.List;

/**
 * @author yrz
 */
@Data
public class NavInfo {

    private Integer id;

    private String navName;

    private Integer navParentId;

    private String url;

    private String icon;

    private List<NavInfo> nav;

    public NavInfo(Integer id, String navName ,String url,String icon ,Integer navParentId) {
        this.id = id;
        this.navName = navName;
        this.url = url;
        this.icon = icon;
        this.navParentId = navParentId;
    }
}
