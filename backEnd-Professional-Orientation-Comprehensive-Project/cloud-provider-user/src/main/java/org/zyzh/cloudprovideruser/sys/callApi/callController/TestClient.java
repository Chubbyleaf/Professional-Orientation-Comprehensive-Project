package org.zyzh.cloudprovideruser.sys.callApi.callController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zyzh.cloudprovideruser.sys.callApi.callService.TestService;

import java.util.List;

@RestController
public class TestClient {
    @Autowired
    private TestService testService;

    @GetMapping("/Hello/getHello")
    public String getClient1(){
        return testService.getHello1();
    }

    @GetMapping("/Hello/getString/{s}")
    public String getString(@PathVariable("s") String s) {
        return testService.getString(s);
    }


}
