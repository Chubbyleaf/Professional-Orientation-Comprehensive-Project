package org.zyzh.cloudproviderteach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zyzh.cloudproviderteach.service.TestService;

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


}
