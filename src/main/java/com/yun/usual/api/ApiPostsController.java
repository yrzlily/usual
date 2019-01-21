package com.yun.usual.api;

import com.yun.usual.bean.Result;
import com.yun.usual.entity.Posts;
import com.yun.usual.entity.Reply;
import com.yun.usual.entity.User;
import com.yun.usual.repository.ImageRepository;
import com.yun.usual.repository.PostsRepository;
import com.yun.usual.repository.UserRepository;
import com.yun.usual.service.PostsService;
import com.yun.usual.utils.ResultUtils;
import com.yun.usual.utils.SessionUtils;
import com.yun.usual.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/api/posts")
public class ApiPostsController {

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsService postsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;

    private Map<String, Object> result = new LinkedHashMap<>();

    /**
     * 帖子列表
     * @param pageable
     * @param classifyId
     * @return
     */
    @GetMapping("/index")
    public Result index(Pageable pageable, @RequestParam("classify_id")Integer classifyId){

        pageable = PageRequest.of(pageable.getPageNumber()-1 , pageable.getPageSize());

        Page<Posts> list = postsService.findPage(pageable, classifyId);

        result.put("data",list.getContent());


        return ResultUtils.success("success",result);
    }

    /**
     * 发布帖子
     * @param map
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Result send(@RequestBody Map<String, Object> map){

        Posts posts = new Posts();
        User user = userRepository.findById(SessionUtils.getUserId()).get();

        posts.setUser_id(user.getId());
        posts.setContent(String.valueOf(map.get("content")));
        posts.setClassify_id(Integer.valueOf(String.valueOf(map.get("classify_id"))));
        posts = postsRepository.save(posts);

        if(map.get("img") != null){
            List<Integer> list = StringUtils.stringToArray(String.valueOf(map.get("img")));
            imageRepository.updateInIdList(posts.getId(), String.valueOf(map.get("type")), list);
        }

        return ResultUtils.error("send fail");
    }

    /**
     * 帖子详情
     * @param id
     * @return
     */
    @GetMapping("/info")
    public Result info(@RequestParam("id")Integer id){

        Posts posts = postsRepository.findById(id).get();
        return ResultUtils.success("读取成功",posts);
    }

    @GetMapping("/my_posts")
    public Result myPosts(Pageable pageable, @RequestParam("classify_id")Integer classifyId){
        pageable = PageRequest.of(pageable.getPageNumber()-1 , pageable.getPageSize());

        Page<Posts> list = postsService.findMyPost(pageable, classifyId , SessionUtils.getUserId());

        result.put("data",list.getContent());
        return ResultUtils.success("success",result);
    }

    @PostMapping("/report")
    public Result report(@RequestBody Reply reply){
        postsRepository.updateStatus(reply.getId());

        return ResultUtils.success("report success",null);
    }

    @GetMapping("/search")
    public Result search(Pageable pageable, @RequestParam("keyword")String keyword){
        pageable = PageRequest.of(pageable.getPageNumber()-1 , pageable.getPageSize());

        Page<Posts> list = postsService.findSearchPost(pageable, keyword);

        result.put("data",list.getContent());
        return ResultUtils.success("success",result);

    }

}
