package com.example.cloudprovidermusic.dao;


import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cloudprovidermusic.dto.AudioComplete;
import com.example.cloudprovidermusic.dto.AudioWithTag;
import com.example.cloudprovidermusic.entity.Collection;
import org.apache.ibatis.annotations.*;
import com.example.cloudprovidermusic.entity.AudioPublic;

/**
 * (AudioPublic)表数据库访问层
 *
 * @author PinkCrow007
 * @since 2022-04-19 23:02:31
 */
public interface AudioPublicDao extends BaseMapper<AudioPublic> {
    /**
     * 返回带标签列表的音乐
     * @param wrapper
     * @return
     */
    @Select("select * from audio_public ${ew.customSqlSegment} ")
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
    List <AudioWithTag> findAudioAndTag(@Param("ew") QueryWrapper wrapper);


    /**
     * 返回带有作者名、头像、标签列表的音乐
     * @param audioId
     * @return
     */

    @Select("select * from audio_public,user where audio_public.apub_author_id=user_id and audio_public.audio_id=#{audioId}")
    @Results({
            @Result(id = true,property = "audioId",column = "audio_id"),
            @Result(property = "apubAuthorId",column = "apub_author_id"),
            @Result(property = "authorName",column = "user_name"),
            @Result(property = "audioName",column = "audio_name"),
            @Result(property = "avatarUrl",column = "avatar_url"),
            @Result(property = "imgUrl",column = "img_url"),
            @Result(property = "audioUrl",column = "audio_url"),
            @Result(property = "tagList",column = "audio_id",
//                    javaType = List.class,
                    many = @Many(select = "com.example.cloudprovidermusic.dao.TagDao.findByAudioId"))
    })
    List <AudioComplete> findFullByAudioId(int audioId);


    @Select("select * from audio_collection ac,collection c where ac.ac_collection_id=c.collection_id and #{audioId}=ac.ac_audio_id and #{userId}=c.col_owner_id")
    @Results({
            @Result(id = true,property = "collectionId",column = "collection_id"),
            @Result(property = "collectionName",column = "collection_name"),
    })
    List<Collection>findCollectionByAudioIdAndUserId(int audioId, String userId);

    /**
     * 10条收藏数最多的音乐
     * @return
     */
    @Select("SELECT `audio_id`,`audio_name`,`status`,`audio_url`,`img_url`,`identity`,`apub_author_id`,COUNT(*) \n" +
            "FROM `audio_public` , `audio_collection`\n" +
            "WHERE `audio_id`=`ac_audio_id` AND `status`=0\n" +
            "GROUP BY `audio_id`\n" +
            "ORDER BY COUNT(*) DESC\n" +
            "LIMIT 10")
    @Results({
            @Result(id = true,property = "audioId",column = "audio_id"),
            @Result(property = "apubAuthorId",column = "apub_author_id"),
            @Result(property = "audioName",column = "audio_name"),
            @Result(property = "imgUrl",column = "img_url"),
            @Result(property = "audioUrl",column = "audio_url"),
            @Result(property = "tagList",column = "audio_id",
                    many = @Many(select = "com.example.cloudprovidermusic.dao.TagDao.findByAudioId"))
    })
    List<AudioWithTag>topMusic();
/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<AudioPublic> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<AudioPublic> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<AudioPublic> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<AudioPublic> entities);

}

