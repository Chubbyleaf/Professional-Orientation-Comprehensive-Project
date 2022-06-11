package org.zyzh.cloudproviderteach.callApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zyzh.cloudproviderteach.callApi.service.TestService;

@RestController
public class TestClient {
    @Autowired
    private TestService testService;

    @GetMapping("/Hello/getHello")
    public String getClient1(){
        return testService.getHello1();
    }

//    @GetMapping("/Hello/getString/{s}")
//    public String getString(@PathVariable("s") String s) {
//        return testService.getString(s);
//    }


}
