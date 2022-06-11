package com.example.cloudprovidermaker.sys.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudprovidermaker.sys.entity.AudioPrivateSchema;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AudioPrivateMapper extends BaseMapper<AudioPrivateSchema> {


    //获得所有的私有表中的简谱文件
    @Results(id = "getalltxt",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "txt_url", column = "txt_url"),
                    @Result(property = "create_time", column = "create_time"),
            })
    @Select("select * from audio_private where apri_author_id=#{userId} and txt_url is not Null")
    List<AudioPrivateSchema> getalltxt(@Param("userId")String userId);

    //根据私有表中的名字寻找
    @Results(id = "findByName",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "apri_author_id", column = "apri_author_id")
            })
    @Select("select * from audio_private where audio_name=#{audioName}")
    AudioPrivateSchema findByName(@Param("audioName")String audioName);

    //向私有表中保存简谱文件
    @Results(id = "save",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "apri_author_id", column = "apri_author_id"),
                    @Result(property = "audio_url", column = "audio_url"),
                    @Result(property = "txt_url", column = "txt_url"),
                    @Result(property = "video_url", column = "video_url"),
                    @Result(property = "create_time", column = "create_time"),
                    @Result(property = "key", column = "key"),
            })
    @Insert(" insert into audio_private(audio_name,create_time,txt_url,apri_author_id) values (#{ret.audio_name},#{ret.create_time},#{ret.txt_url},#{ret.apri_author_id});")
    @Options(useGeneratedKeys = true,keyProperty = "audio_id",keyColumn = "audio_id")
    void save(@Param("ret")AudioPrivateSchema ret);

    //向私有表中保存MP4文件
    @Results(id = "saveMp4",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "apri_author_id", column = "apri_author_id"),
                    @Result(property = "audio_url", column = "audio_url"),
                    @Result(property = "txt_url", column = "txt_url"),
                    @Result(property = "video_url", column = "video_url"),
                    @Result(property = "create_time", column = "create_time"),
                    @Result(property = "key", column = "key"),
            })
    @Insert(" insert into audio_private(audio_name,create_time,video_url,apri_author_id) values (#{ret.audio_name},#{ret.create_time},#{ret.video_url},#{ret.apri_author_id});")
    @Options(useGeneratedKeys = true,keyProperty = "audio_id",keyColumn = "audio_id")
    void saveMp4(@Param("ret")AudioPrivateSchema ret);

    //向私有表中保存MP3文件
    @Results(id = "saveMp3",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "apri_author_id", column = "apri_author_id"),
                    @Result(property = "audio_url", column = "audio_url"),
                    @Result(property = "txt_url", column = "txt_url"),
                    @Result(property = "video_url", column = "video_url"),
                    @Result(property = "create_time", column = "create_time"),
                    @Result(property = "key", column = "key"),
            })
    @Insert(" insert into audio_private(audio_name,create_time,audio_url,apri_author_id) values (#{ret.audio_name},#{ret.create_time},#{ret.audio_url},#{ret.apri_author_id});")
    @Options(useGeneratedKeys = true,keyProperty = "audio_id",keyColumn = "audio_id")
    void saveMp3(@Param("ret")AudioPrivateSchema ret);

    //获取私有表中所有的MP3文件
    @Results(id = "getallMp3",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "audio_url", column = "audio_url"),
                    @Result(property = "create_time", column = "create_time"),
            })
    @Select("select * from audio_private where apri_author_id=#{userId} and audio_url is not Null and audio_name not like'%[钢琴]%'and audio_name not like'%[鼓点]%'")
    List<AudioPrivateSchema> getallMp3(@Param("userId")String userId);

    //获取私有表中所有的MP3文件
    @Results(id = "getallPMp3",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "audio_url", column = "audio_url"),
                    @Result(property = "create_time", column = "create_time"),
            })
    @Select("select * from audio_private where apri_author_id=#{userId} and audio_url is not Null and (audio_name like'%[钢琴]%' or audio_name like'%[鼓点]%' )")
    List<AudioPrivateSchema> getallPMp3(@Param("userId")String userId);

    //根据MP3获得音乐文件
    @Results(id = "findMp3Byid",
            value = {
                    @Result(property = "audio_id", column = "audio_id", id = true),
                    @Result(property = "audio_name", column = "audio_name"),
                    @Result(property = "audio_url", column = "audio_url"),
                    @Result(property = "create_time", column = "create_time"),
            })
    @Select("select * from audio_private where audio_id=#{bgm_value}")
    AudioPrivateSchema findMp3Byid(@Param("bgm_value")String bgm_value);
}
