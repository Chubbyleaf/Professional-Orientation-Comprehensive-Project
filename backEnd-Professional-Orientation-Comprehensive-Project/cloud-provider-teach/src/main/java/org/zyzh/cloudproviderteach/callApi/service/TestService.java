package org.zyzh.cloudproviderteach.callApi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//name 为product项目中application.yml配置文件中的application.name;
//path 为product项目中application.yml配置文件中的context.path;
@FeignClient(name = "cloud-provider-user",path ="/hello" )
//@Componet注解最好加上，不加idea会显示有错误，但是不影响系统运行；
@Component
public interface TestService {
    @RequestMapping(value = "getHello")
    String getHello1();

    @RequestMapping(value = "/getString/{s}")
    String getString(@PathVariable("s") String s);



}
