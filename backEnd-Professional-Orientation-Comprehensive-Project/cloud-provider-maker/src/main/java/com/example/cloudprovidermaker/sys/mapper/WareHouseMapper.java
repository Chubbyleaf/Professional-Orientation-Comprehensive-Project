package com.example.cloudprovidermaker.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudprovidermaker.sys.entity.AudioPrivateSchema;
import com.example.cloudprovidermaker.sys.entity.WareHouseSchema;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WareHouseMapper extends BaseMapper<WareHouseSchema> {
    @Select("select * from warehouse where w_owner_id=#{userId}")
    List<WareHouseSchema> getall(@Param("userId")String userId);
}
