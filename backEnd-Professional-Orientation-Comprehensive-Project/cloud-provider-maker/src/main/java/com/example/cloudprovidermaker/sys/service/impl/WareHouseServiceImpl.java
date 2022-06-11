package com.example.cloudprovidermaker.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermaker.sys.entity.AudioPrivateSchema;
import com.example.cloudprovidermaker.sys.entity.WareHouseSchema;
import com.example.cloudprovidermaker.sys.mapper.AudioPrivateMapper;
import com.example.cloudprovidermaker.sys.mapper.WareHouseMapper;
import com.example.cloudprovidermaker.sys.service.AudioPrivateService;
import com.example.cloudprovidermaker.sys.service.WareHouseService;
import com.example.cloudprovidermaker.sys.vo.TxtGetAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WareHouseServiceImpl extends ServiceImpl<WareHouseMapper, WareHouseSchema> implements WareHouseService {
    @Autowired
    WareHouseMapper wareHouseMapper;

    @Override
    public List<WareHouseSchema> getall(String userId) {
        List<WareHouseSchema> ret = new ArrayList<>();
        List<WareHouseSchema> txt = wareHouseMapper.getall(userId);
        for (int i = 0; i < txt.size(); i++) {
            WareHouseSchema tmp = new WareHouseSchema();
            tmp.setWarehouse_id( txt.get(i).getWarehouse_id() );
            tmp.setWarehouse_name( txt.get(i).getWarehouse_name() );
            tmp.setCreate_time(txt.get(i).getCreate_time());
            tmp.setW_owner_id( txt.get(i).getW_owner_id() );
            ret.add(tmp);
        }
        return ret;
    }

}
