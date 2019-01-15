package com.yun.usual.repository;

import com.yun.usual.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yrz
 */
@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {

    /**
     * 登录
     * @param username
     * @return
     */
    AdminUser findByAdminUsername(String username);

}
