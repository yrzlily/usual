package com.yun.usual.service.impl;

import com.yun.usual.entity.Reply;
import com.yun.usual.repository.ReplyRepository;
import com.yun.usual.service.ReplyService;
import com.yun.usual.utils.SessionUtils;
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
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public Page<Reply> findPage(Pageable pageable, Integer id) {
        return replyRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();

                if(null != id){
                    predicate.add(criteriaBuilder.equal(root.get("posts_id").as(String.class), id));
                }
                predicate.add(criteriaBuilder.equal(root.get("status").as(String.class),1));
                Predicate[] predicates = new Predicate[predicate.size()];
                criteriaQuery.where(criteriaBuilder.and(predicate.toArray(predicates)));
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id").as(Integer.class)));
                criteriaQuery.distinct(true);
                return criteriaQuery.getRestriction();
            }
        }, pageable);
    }

    @Override
    public Page<Reply> findMyComments(Pageable pageable) {
        return replyRepository.findAll(new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicate = new ArrayList<>();

                predicate.add(criteriaBuilder.equal(root.get("user_id").as(String.class), SessionUtils.getUserId()));
                predicate.add(criteriaBuilder.equal(root.get("status").as(String.class),1));
                Predicate[] predicates = new Predicate[predicate.size()];
                criteriaQuery.where(criteriaBuilder.and(predicate.toArray(predicates)));
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id").as(Integer.class)));
                criteriaQuery.distinct(true);
                return criteriaQuery.getRestriction();
            }
        }, pageable);
    }
}
