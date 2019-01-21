package com.yun.usual.service.impl;

import com.yun.usual.entity.Posts;
import com.yun.usual.repository.PostsRepository;
import com.yun.usual.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yrz
 */
@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public Page<Posts> findPage(Pageable pageable, Integer classify) {
        return postsRepository.findAll(new Specification<Posts>() {
            @Override
            public Predicate toPredicate(Root<Posts> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();

                if(null != classify){
                    predicate.add(criteriaBuilder.equal(root.get("classify_id").as(Integer.class),classify));
                }
                predicate.add(criteriaBuilder.equal(root.get("status").as(String.class),1));
                Predicate[] predicates = new Predicate[predicate.size()];
                criteriaQuery.where(criteriaBuilder.and(predicate.toArray(predicates)));
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id").as(Integer.class)));
                criteriaQuery.distinct(true);
                return criteriaQuery.getRestriction();
            }
        },pageable);
    }

    @Override
    public Page<Posts> findMyPost(Pageable pageable, Integer classify, Integer user_id) {
        return postsRepository.findAll(new Specification<Posts>() {
            @Override
            public Predicate toPredicate(Root<Posts> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();

                if(null != classify){
                    predicate.add(criteriaBuilder.equal(root.get("classify_id").as(Integer.class),classify));
                }
                predicate.add(criteriaBuilder.equal(root.get("user_id").as(Integer.class),user_id));
                predicate.add(criteriaBuilder.equal(root.get("status").as(String.class),1));
                Predicate[] predicates = new Predicate[predicate.size()];
                criteriaQuery.where(criteriaBuilder.and(predicate.toArray(predicates)));
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id").as(Integer.class)));
                criteriaQuery.distinct(true);
                return criteriaQuery.getRestriction();
            }
        },pageable);
    }

    @Override
    public Page<Posts> findSearchPost(Pageable pageable, String search) {
        return postsRepository.findAll(new Specification<Posts>() {
            @Override
            public Predicate toPredicate(Root<Posts> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();

                if(null != search){
                    predicate.add(criteriaBuilder.equal(root.get("content").as(String.class),search));
                }
                predicate.add(criteriaBuilder.equal(root.get("status").as(String.class),1));

                Predicate[] predicates = new Predicate[predicate.size()];
                criteriaQuery.where(criteriaBuilder.and(predicate.toArray(predicates)));
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id").as(Integer.class)));
                criteriaQuery.distinct(true);
                return criteriaQuery.getRestriction();
            }
        },pageable);
    }

    @Override
    public Page<Posts> findTablePost(Pageable pageable, Integer id, Integer status, String content) {
        return postsRepository.findAll(new Specification<Posts>() {
            @Override
            public Predicate toPredicate(Root<Posts> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();

                if(null != id){
                    predicate.add(criteriaBuilder.equal(root.get("id").as(Integer.class),id));
                }

                if(null != status){
                    predicate.add(criteriaBuilder.equal(root.get("status").as(Integer.class),status));
                }else{
                    predicate.add(criteriaBuilder.in(root.get("status")).value(0).value(1).value(2));
                }

                if(null != content){
                    predicate.add(criteriaBuilder.like(root.get("content").as(String.class),"%" + content + "%"));
                }


                Predicate[] predicates = new Predicate[predicate.size()];
                criteriaQuery.where(criteriaBuilder.and(predicate.toArray(predicates)));
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id").as(Integer.class)));
                criteriaQuery.distinct(true);
                return criteriaQuery.getRestriction();
            }
        },pageable);
    }
}
