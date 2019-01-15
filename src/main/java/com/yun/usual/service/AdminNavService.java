package com.yun.usual.service;

import com.yun.usual.bean.LayTree;
import com.yun.usual.dto.NavInfo;

import java.util.List;

/**
 * @author yrz
 */
public interface AdminNavService {

    /**
     * 子栏目递归
     * @param id 栏目id
     * @param nav 全部数据
     * @return List
     */
    List<NavInfo> findChild(Integer id , List<NavInfo> nav);


    /**
     * Lay树节点
     * @param id 栏目id
     * @param nav 全部数据
     * @return List
     */
    List<LayTree> findTree(Integer id , List<LayTree> nav);

}
