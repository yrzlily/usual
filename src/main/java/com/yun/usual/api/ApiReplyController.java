package com.yun.usual.api;

import com.yun.usual.bean.Result;
import com.yun.usual.entity.Reply;
import com.yun.usual.repository.ReplyRepository;
import com.yun.usual.service.ReplyService;
import com.yun.usual.utils.ResultUtils;
import com.yun.usual.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/api/reply")
public class ApiReplyController {

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private ReplyService replyService;

    private Map<String, Object> result = new LinkedHashMap<>();

    @GetMapping("/index")
    public Result index(Pageable pageable, @RequestParam("id")Integer id){
        pageable = PageRequest.of(pageable.getPageNumber()-1 , pageable.getPageSize());
        Page<Reply> replies = replyService.findPage(pageable, id);

        result.put("data",replies.getContent());

        return ResultUtils.success("acquire success" ,result);
    }

    @GetMapping("/my_comments")
    public Result myComments(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber()-1 , pageable.getPageSize());
        Page<Reply> replies = replyService.findMyComments(pageable);
        result.put("data",replies.getContent());

        return ResultUtils.success("acquire success" ,result);
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid Reply reply){
        System.out.println(reply);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        reply.setUser_id(SessionUtils.getUserId());
        reply.setCreate_time(df.format(System.currentTimeMillis()));
        reply = replyRepository.save(reply);

        return ResultUtils.success("Comment on success", reply);
    }

    @PostMapping("/report")
    public Result report(@RequestBody @Valid Reply reply){

        replyRepository.updateStatus(reply.getId());

        return ResultUtils.success("report success", reply);
    }

}
