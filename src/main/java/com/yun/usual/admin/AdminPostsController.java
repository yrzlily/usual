package com.yun.usual.admin;

import com.yun.usual.bean.Layer;
import com.yun.usual.bean.Result;
import com.yun.usual.entity.Posts;
import com.yun.usual.repository.PostsRepository;
import com.yun.usual.service.PostsService;
import com.yun.usual.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yrz
 */
@Controller
@RequestMapping("/admin/posts")
public class AdminPostsController {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsService postsService;

    @GetMapping("/index")
    public ModelAndView index(){

        return new ModelAndView("/admin/posts/index");
    }

    @ResponseBody
    @PostMapping("/list")
    public Layer list(Pageable pageable, @RequestParam(value = "id", required = false)Integer id, @RequestParam(value = "status", required = false)Integer status, @RequestParam(value = "content", required = false)String content){
        pageable = PageRequest.of(pageable.getPageNumber() -1, pageable.getPageSize());

        Page<Posts> list = postsService.findTablePost(pageable, id, status, content);

        return ResultUtils.layer(list.getTotalPages() , list.getContent());
    }

    @ResponseBody
    @PostMapping("/delete")
    public Result delete(@RequestParam("id")Integer id){
        postsRepository.deleteTableStatus(id);
        return ResultUtils.success("删除成功", id);
    }
}
