package com.example.cloudprovidermaker.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudprovidermaker.sys.entity.AudioPrivateSchema;
import com.example.cloudprovidermaker.sys.entity.AudioWareHouseSchema;
import com.example.cloudprovidermaker.sys.entity.WareHouseSchema;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AudioWareHouseMapper extends BaseMapper<AudioWareHouseSchema> {
    @Insert(" insert into audio_warehouse(aw_warehouse_id,aw_audio_private_id) values (#{rr.aw_warehouse_id},#{rr.aw_audio_private_id});")
    void save(@Param("rr")AudioWareHouseSchema rr);
}
