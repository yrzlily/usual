package com.yun.usual.repository;

import com.yun.usual.entity.Posts;
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
public interface PostsRepository extends JpaRepository<Posts, Integer> {

    /**
     * 条件分页查询
     * @param specification
     * @param pageable
     * @return
     */
    Page<Posts> findAll(Specification<Posts> specification, Pageable pageable);

    /**
     * 举报
     * @param id
     * @return
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update Posts p set p.status = 0 where p.id = ?1")
    void updateStatus(Integer id);

    /**
     * 删除用户帖子
     * @param uid
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update Posts p set p.status = 3 where user_id = ?1")
    void deleteStatus(Integer uid);

    /**
     * 删除用户帖子
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update Posts p set p.status = 3 where p.id = ?1")
    void deleteTableStatus(Integer id);
}
