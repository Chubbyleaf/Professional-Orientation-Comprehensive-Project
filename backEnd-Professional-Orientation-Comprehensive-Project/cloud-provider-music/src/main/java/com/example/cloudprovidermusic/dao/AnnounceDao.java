package com.example.cloudprovidermusic.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.example.cloudprovidermusic.entity.Announce;

/**
 * (Announce)表数据库访问层
 *
 * @author PinkCrow007
 * @since 2022-05-15 23:03:54
 */
public interface AnnounceDao extends BaseMapper<Announce> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<Announce> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<Announce> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<Announce> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<Announce> entities);

}

