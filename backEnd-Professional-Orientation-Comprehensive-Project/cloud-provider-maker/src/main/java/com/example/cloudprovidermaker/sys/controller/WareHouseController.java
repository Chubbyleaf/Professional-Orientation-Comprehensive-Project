package com.example.cloudprovidermaker.sys.controller;

import com.example.cloudprovidermaker.sys.entity.WareHouseSchema;
import com.example.cloudprovidermaker.sys.service.AudioPrivateService;
import com.example.cloudprovidermaker.sys.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/WHouse")
public class WareHouseController {
    @Autowired
    WareHouseService wareHouseService;
    // 获取所有简谱信息
    @GetMapping("/find/all")
    public List<WareHouseSchema> findall(String userId) {
        return wareHouseService.getall(userId);
    }


}
