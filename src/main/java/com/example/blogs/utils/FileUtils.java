package com.example.blogs.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.beust.jcommander.ParameterException;
import com.example.blogs.constant.FileConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @create: 2021/12/10
 * @author: fb
 * @Description: 文件上传工具类
 */
@Slf4j
public class FileUtils {
    
    /**
     * 文件上传
     * @param multipartFile 文件
     * @return
     * @throws IOException
     */
    public static String uploadFile(MultipartFile multipartFile) throws IOException {
    
        if(null == multipartFile){
            throw new ParameterException("上传文件不能为空");
        }
        if(FileConstant.maxSize < multipartFile.getSize()){
            throw new ParameterException("上传文件大小不能超过" + FileConstant.maxSize);
        }
        String folder = FileConstant.targetUrl + File.separator;
        if(!FileUtil.exist(folder)){
            FileUtil.mkdir(folder);
        }
        
        // 文件扩展名
        String fileExt = Objects.requireNonNull(multipartFile.getOriginalFilename()).substring(multipartFile.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        String fileName = DateUtil.format(new Date(), "yyyy/MM/dd/") + IdUtil.simpleUUID() + fileExt;
        String path = folder + fileName;
        
        File file = new File(path);
        if(FileUtil.exist(file)){
            throw new ParameterException("文件已存在");
        }
        File checkFile = FileUtil.writeBytes(multipartFile.getBytes(), path);
        if(checkFile.length() < 0){
            throw new ParameterException("文件上传失败");
        }
        return FileConstant.prefix + fileName;
    }
}
