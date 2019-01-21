package com.yun.usual.service;

import com.yun.usual.entity.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author yrz
 */
public interface PostsService {

    /**
     * 分页条件查询
     * @param pageable
     * @param classify
     * @return
     */
    Page<Posts> findPage(Pageable pageable , Integer classify);

    /**
     * 我的帖子搜索
     * @param pageable
     * @param classify
     * @param user_id
     * @return
     */
    Page<Posts> findMyPost(Pageable pageable , Integer classify, Integer user_id);

    /**
     * 帖子检索
     * @param pageable
     * @param search
     * @return
     */
    Page<Posts> findSearchPost(Pageable pageable , String search);

    /**
     * 帖子检索
     * @param pageable
     * @param id
     * @param status
     * @param content
     * @return
     */
    Page<Posts> findTablePost(Pageable pageable ,Integer id, Integer status, String content);
}
