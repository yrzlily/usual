package com.yun.usual.repository;

import com.yun.usual.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author yrz
 */
public interface ImageRepository extends JpaRepository<Image, Integer> {

    /**
     * 绑定帖子图片
     * @param pid
     * @param type
     * @param list
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update Image img set img.posts_id = ?1 , img.type = ?2 where img.id in(?3)")
    void updateInIdList(Integer pid, String type, List<Integer> list);

}
