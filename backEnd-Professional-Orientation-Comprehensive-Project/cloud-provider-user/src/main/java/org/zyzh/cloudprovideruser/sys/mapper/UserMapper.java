package org.zyzh.cloudprovideruser.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.dto.UserFollowDto;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
