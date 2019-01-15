package com.yun.usual.repository;

import com.yun.usual.bean.LayTree;
import com.yun.usual.dto.NavInfo;
import com.yun.usual.entity.AdminNav;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author yrz
 */
@Repository
public interface AdminNavRepository extends JpaRepository<AdminNav, Integer> {

    /**
     * 过滤查找
     * @return List
     */
    @Query("select new com.yun.usual.dto.NavInfo(n.id,n.navName,n.url,n.icon,n.navParentId) from AdminNav n")
    List<NavInfo> findAllList();

    /**
     * 分页查询
     * @param specification
     * @param pageable
     * @return
     */
    Page<AdminNav> findAll(Specification<AdminNav> specification, Pageable pageable);

    /**
     * 过滤查找
     * @return List
     */
    @Query("select new com.yun.usual.bean.LayTree(n.navName,n.url,n.id,n.navParentId,n.sort,n.icon) from AdminNav n")
    List<LayTree> findAllTree();

    /**
     * 修改部分
     * @param navName
     * @param url
     * @param icon
     * @param sort
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    @Modifying
    @Query("update AdminNav n set n.navName = ?1 , n.url = ?2, n.icon = ?3 ,n.sort = ?4 where n.id = ?5")
    void update(String navName , String url , String icon , Integer sort , Integer id);
}
