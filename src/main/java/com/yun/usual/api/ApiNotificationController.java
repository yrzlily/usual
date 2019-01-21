package com.yun.usual.api;

import com.yun.usual.bean.Result;
import com.yun.usual.entity.Notification;
import com.yun.usual.repository.NotificationRepository;
import com.yun.usual.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/api/notification")
public class ApiNotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    private Map<String, Object> result = new LinkedHashMap<>();

    @GetMapping("/index")
    public Result index(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber()-1 , pageable.getPageSize());

        Page<Notification> notifications = notificationRepository.findAll(pageable);
        result.put("data",notifications.getContent());

        return ResultUtils.success("success",result);
    }

}
