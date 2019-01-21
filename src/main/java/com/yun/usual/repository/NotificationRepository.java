package com.yun.usual.repository;

import com.yun.usual.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yrz
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {


}
