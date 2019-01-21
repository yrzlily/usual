package com.yun.usual.service;

import com.yun.usual.dto.CateInfo;
import com.yun.usual.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author yrz
 */
public interface CategoryService {

    /**
     * 分页查找
     * @param pageable 分页信息
     * @param name 查询条件
     * @param parentId
     * @return 搜索结果
     */
    Page<Category> findAll(Pageable pageable, String name , Integer parentId);

    /**
     * 头部导航列表
     * @param id
     * @return
     */
    List<CateInfo> breadcrumb(Integer id);

}
