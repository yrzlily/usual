package com.yun.usual.repository;

import com.yun.usual.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yrz
 */
@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    /**
     * 查找用户
     * @param openid
     * @return
     */
    User findByOpenid(String openid);

}
