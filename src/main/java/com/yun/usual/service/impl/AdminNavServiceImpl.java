package com.yun.usual.service.impl;

import com.yun.usual.bean.LayTree;
import com.yun.usual.dto.NavInfo;
import com.yun.usual.service.AdminNavService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yrz
 */
@Service
public class AdminNavServiceImpl implements AdminNavService {


    @Override
    public List<NavInfo> findChild(Integer id, List<NavInfo> nav) {
        List<NavInfo> list = new ArrayList<>();

        for (NavInfo n:nav){
            if(n.getNavParentId().equals(id)){

                n.setNav(findChild(n.getId() , nav));
                list.add(n);
            }
        }

        return list;
    }

    @Override
    public List<LayTree> findTree(Integer id, List<LayTree> nav) {
        List<LayTree> list = new ArrayList<>();

        for (LayTree n:nav){
            if(n.getNavParentId().equals(id)){

                n.setChildren(findTree(n.getId() , nav));
                list.add(n);
            }
        }

        return list;
    }
}
