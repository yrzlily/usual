package com.yun.usual.service;

import com.yun.usual.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * @author yrz
 */
public interface ReplyService {

    /**
     * 分页条件查询
     * @param pageable
     * @param id
     * @return
     */
    Page<Reply> findPage(Pageable pageable, Integer id);

    /**
     * 我的回复
     * @param pageable
     * @return
     */
    Page<Reply> findMyComments(Pageable pageable);


}
