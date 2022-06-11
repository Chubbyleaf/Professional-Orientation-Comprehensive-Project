package com.example.cloudprovidermusic.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.cloudprovidermusic.dto.AudioWithTag;
import org.apache.ibatis.annotations.*;
import com.example.cloudprovidermusic.entity.User;

/**
 * (User)表数据库访问层
 *
 * @author PinkCrow007
 * @since 2022-04-26 18:37:18
 */
public interface UserDao extends BaseMapper<User> {
    /**
     * 返回粉丝数最多的10个用户
     * @return
     */
    @Select("SELECT `user_id`,`user_name`,`avatar_url`,COUNT(*) \n" +
            "FROM `user` , `user_follower`\n" +
            "WHERE `user_id`=`user_id_mine` AND `identity`=1\n" +
            "GROUP BY `user_id`\n" +
            "ORDER BY COUNT(*) DESC\n" +
            "LIMIT 10")

    List<User>topUser();
/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<User> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<User> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<User> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<User> entities);

}

