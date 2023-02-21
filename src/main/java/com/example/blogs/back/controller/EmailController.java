package com.example.blogs.back.controller;

import com.example.blogs.common.Result;
import com.example.blogs.dto.ToEmailDTO;
import com.example.blogs.service.RedisService;
import com.example.blogs.utils.VerCodeGenerateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 言覃
 * @Date: 2022/12/13/23:43
 * @Description: 邮箱验证码
 */
@RestController
@RequestMapping("v1/back/email")
@Api(value = "API - EmailController", tags = "发送邮箱")
public class EmailController {
    @Resource
    private JavaMailSender mailSender;
    @Resource
    private RedisService redisService;

    /**
     * 获得发送邮件的账户
     */
    @Value("${spring.mail.username}")
    private String from;

    @ApiOperation("发送注册验证码")
    @PostMapping("sendEmail")
    public Result<?> commonEmail(@RequestBody @Validated ToEmailDTO toEmail) {
        //创建邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        //生成验证码
        String verCode = VerCodeGenerateUtil.generateVerCode();
        //发送验证码
        message.setFrom(from);
        message.setTo(toEmail.getTos());
        message.setSubject("您本次的验证码是");
        message.setText("尊敬的"+toEmail.getTos()[0]+",您好:\n"
                + "\n本次请求的邮件验证码为:" + verCode + ",本验证码 5 分钟内效，请及时输入。（请勿泄露此验证码）\n"
                + "\n如非本人操作，请忽略该邮件。\n(这是一封通过自动发送的邮件，请不要直接回复）");
        mailSender.send(message);
        //验证码缓存到
        redisService.set(toEmail.getTos()[0], verCode, 1800);
        return Result.success(verCode);
    }
}
