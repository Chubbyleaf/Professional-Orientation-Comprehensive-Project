package com.example.cloudprovidermaker.sys.service;

import com.example.cloudprovidermaker.sys.entity.WareHouseSchema;
import com.example.cloudprovidermaker.sys.vo.TxtGetAll;

import java.util.List;

public interface WareHouseService {
    List<WareHouseSchema> getall(String userId);
}
