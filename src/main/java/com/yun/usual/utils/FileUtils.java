package com.yun.usual.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

/**
 * @author yrz
 */
@Slf4j
public class FileUtils {

    private static final String FILEPATH = "/static/upload/";

    public static com.yun.usual.bean.File upload(MultipartFile file){

        com.yun.usual.bean.File files = new com.yun.usual.bean.File();

        String filePath = null;

        try {
            String pathPrefix = ResourceUtils.getURL("classpath:").getPath();
            File pathDir = new File(pathPrefix);

            log.info("path: {}",pathPrefix);
            File dir = new File(pathDir.getAbsolutePath() , FILEPATH);
            if(!dir.exists()){
                dir.mkdir();
            }

            String suffix = file.getOriginalFilename().substring(Objects.requireNonNull(file.getOriginalFilename()).lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;

            File serverFile = new File(dir + "/" + fileName);
            filePath = fileName;
            log.info("fileMessage:{}",serverFile);
            file.transferTo(serverFile);

        }catch (Exception e){
            e.printStackTrace();
        }

        files.setFileName(file.getOriginalFilename());
        files.setSize(file.getSize());
        files.setPath(FILEPATH + filePath);
        return files;
    }

}
