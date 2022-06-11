package com.example.cloudprovidermusic.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudprovidermusic.dto.CommentWithUser;
import org.apache.ibatis.annotations.Param;
import com.example.cloudprovidermusic.entity.Comment;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * (Comment)表数据库访问层
 *
 * @author PinkCrow007
 * @since 2022-05-11 09:09:11
 */
public interface CommentDao extends BaseMapper<Comment> {

    @Select("select * from comment c,user u where #{audioId}=c.com_audio_public_id and c.com_owner_id=u.user_id")
    @Results({
            @Result(column = "comment_id",property = "commentId"),
            @Result(column = "content",property = "content"),
            @Result(column = "create_time",property = "createTime"),
            @Result(column = "com_audio_public_id",property = "comAudioPublicId"),
            @Result(column = "com_owner_id",property = "comOwnerId"),
            @Result(column = "user_name",property = "userName"),
            @Result(column = "avatar_url",property = "avatarUrl")
    })
    public List<CommentWithUser> findAll(int audioId);


/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<Comment> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<Comment> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<Comment> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<Comment> entities);

}

