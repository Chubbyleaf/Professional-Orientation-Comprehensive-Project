package org.zyzh.cloudprovideruser.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.service.TestService;
import org.zyzh.cloudprovideruser.sys.vo.LoginVo;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class TestController {
    @Autowired
    private TestService testService;


    @GetMapping("/getHello")
    public String getHello() {
        return testService.getHello();
    }

    @GetMapping("/getString/{s}")
    public String getString(@PathVariable("s") String s) {
        return testService.getString(s);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return testService.getAll();
    }

    @GetMapping("/one/{id}")
    public User getOne(@PathVariable("id") String id) {
        return testService.getSpecific(id);
    }

    @PostMapping("/getUser")
    public User getUser(@Validated @RequestBody LoginVo loginVo)
    {
        System.out.println("provider:"+loginVo.getLoginKey());
        return testService.getById(loginVo.getLoginKey());
    }

    @Resource
    private JavaMailSender mailSender;

    //	获得.yml文件发件人信息
    @Value("${spring.mail.username}")

    private String from;
    @GetMapping("/sendEmail")
    public String commonEmail() {
        //创建邮件消息
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置发件人
        message.setFrom(from);
        // 设置收件人
        message.setTo("1442391739@qq.com");
        // 设置邮件标题
        message.setSubject("test");
        message.setText("你好，这是一条用于测试Spring Boot邮件发送功能的邮件！哈哈哈~~~");
        // 发送邮件
        mailSender.send(message);
        return "ok";
    }

}
