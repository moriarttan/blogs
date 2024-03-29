package com.example.blogs;


import com.example.blogs.enums.UserStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.util.Date;

@Slf4j
@SpringBootApplication
@MapperScan("com.example.blogs.mapper")
public class BlogsApplication {
    private static final Logger LOG = LoggerFactory.getLogger(BlogsApplication.class);

    public static void main(String[] args) {
//        SpringApplication.run(BlogsApplication.class, args);
        SpringApplication app = new SpringApplication(BlogsApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }

}
