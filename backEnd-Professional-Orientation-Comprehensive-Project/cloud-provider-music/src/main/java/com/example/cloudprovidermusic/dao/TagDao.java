package com.example.cloudprovidermusic.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudprovidermusic.dto.AudioComplete;
import com.example.cloudprovidermusic.entity.AudioPublic;
import org.apache.ibatis.annotations.*;
import com.example.cloudprovidermusic.entity.Tag;

/**
 * (Tag)表数据库访问层
 *
 * @author PinkCrow007
 * @since 2022-04-26 23:48:01
 */
public interface TagDao extends BaseMapper<Tag> {

@Select("select * from tag,audio_tag where tag.tag_id=audio_tag.at_tag_id and audio_tag.at_audio_public_id=#{audioId}")
List<Tag> findByAudioId(int audioId);

@Results({
            @Result(id = true,property = "audioId",column = "audio_id"),
            @Result(property = "apubAuthorId",column = "apub_author_id"),
            @Result(property = "audioName",column = "audio_name"),
            @Result(property = "imgUrl",column = "img_url"),
            @Result(property = "audioUrl",column = "audio_url"),
            @Result(property = "tagList",column = "audio_id",
//                    javaType = List.class,
                    many = @Many(select = "com.example.cloudprovidermusic.dao.TagDao.findByAudioId"))
    })
//@Select("select tag_id,tag_name,status,comment,create_time,des,audio_url,img_url,identity,apub_author_id " +
//        "from tag,audio_tag where tag.tag_id=audio_tag.at_tag_id and audio_tag.at_audio_public_id=#{audioId}")
//List<AudioComplete> findFullByAudioId(int audioId);
/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<Tag> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<Tag> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<Tag> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<Tag> entities);

}

