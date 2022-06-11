package com.example.cloudprovidermusic.dao;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.example.cloudprovidermusic.entity.Collection;

/**
 * (Collection)表数据库访问层
 *
 * @author PinkCrow007
 * @since 2022-05-16 19:23:37
 */
public interface CollectionDao extends BaseMapper<Collection> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<Collection> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<Collection> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<Collection> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<Collection> entities);

}

