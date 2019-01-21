package com.yun.usual.api;

import com.yun.usual.bean.File;
import com.yun.usual.bean.Result;
import com.yun.usual.entity.Image;
import com.yun.usual.repository.ImageRepository;
import com.yun.usual.utils.FileUtils;
import com.yun.usual.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;

/**
 * @author yrz
 */
@RestController
@RequestMapping("/api/data")
public class ApiDataController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){

        File files = FileUtils.upload(file);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Image image = new Image();

        image.setName(files.getFileName());
        image.setCreate_time(df.format(System.currentTimeMillis()));
        image.setSize(files.getSize());
        image.setSrc(files.getPath());

        image = imageRepository.save(image);

        files.setId(image.getId());

        return ResultUtils.success("上传成功", files);
    }

}
