package org.zyzh.cloudprovideruser.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.zyzh.cloudprovideruser.sys.entity.Announce;

@Mapper
@Repository
public interface AnnounceMapper extends BaseMapper<Announce> {
}
