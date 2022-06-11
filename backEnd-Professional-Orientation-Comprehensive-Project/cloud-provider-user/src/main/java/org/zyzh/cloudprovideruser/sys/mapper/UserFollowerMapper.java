package org.zyzh.cloudprovideruser.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.zyzh.cloudprovideruser.sys.dto.UserFollowerDto;
import org.zyzh.cloudprovideruser.sys.entity.UserFollower;

import java.util.List;

@Mapper
@Repository
public interface UserFollowerMapper extends BaseMapper<UserFollower> {
    @Results(id = "findUserFollower",
            value = {
                    @Result(property = "userId", column = "user_id_mine", id = true),
                    @Result(property = "myFollowerId", column = "user_id_my_follower"),
                    @Result(property = "myFollowerName", column = "user_name"),
                    @Result(property = "myFollowerAvatar", column = "avatar_url"),
                    @Result(property = "myFollowerFollowerNum", column = "follower_num"),
                    @Result(property = "myFollowerCollectionNum", column = "collection_num"),
            })
    @Select("select H.user_id_mine,H.user_id_my_follower,A.user_name,A.avatar_url,D.follower_num,B.collection_num from user_follower H left join user A on H.user_id_my_follower=A.user_id left join(select user_id_mine,count(*) as follower_num from user_follower group by user_id_mine)D on H.user_id_my_follower=D.user_id_mine left join(select col_owner_id,count(*) as collection_num from collection where identity=0 group by col_owner_id)B on H.user_id_my_follower=B.col_owner_id where H.user_id_mine=#{UserId}")
    List<UserFollowerDto> findUserFollower(@Param("UserId")String UserId);
}
