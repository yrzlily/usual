package com.yun.usual.repository;

import com.yun.usual.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author yrz
 */
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    /**
     * 分页条件查询
     * @param specification
     * @param pageable
     * @return
     */
    Page<Reply> findAll(Specification specification , Pageable pageable);

    /**
     * 举报
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update Reply r set r.status = 0 where r.id = ?1")
    void updateStatus(Integer id);
}
