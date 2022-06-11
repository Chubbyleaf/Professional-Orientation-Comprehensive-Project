package org.zyzh.cloudprovideruser.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.zyzh.cloudprovideruser.sys.dto.UserFollowDto;
import org.zyzh.cloudprovideruser.sys.entity.UserFollow;

import java.util.List;

@Mapper
@Repository
public interface UserFollowMapper extends BaseMapper<UserFollow> {

    @Results(id = "findUserFollow",
            value = {
                    @Result(property = "userId", column = "user_id_me", id = true),
                    @Result(property = "myFollowId", column = "user_id_my_follow"),
                    @Result(property = "myFollowName", column = "user_name"),
                    @Result(property = "myFollowAvatar", column = "avatar_url"),
                    @Result(property = "myFollowFollowerNum", column = "follower_num"),
                    @Result(property = "myFollowCollectionNum", column = "collection_num"),
            })
    @Select("select H.user_id_me,H.user_id_my_follow,A.user_name,A.avatar_url,D.follower_num,B.collection_num from user_follow H left join user A on H.user_id_my_follow=A.user_id left join(select user_id_mine,count(*) as follower_num from user_follower group by user_id_mine)D on H.user_id_my_follow=D.user_id_mine left join(select col_owner_id,count(*) as collection_num from collection where identity=0 group by col_owner_id)B on H.user_id_my_follow=B.col_owner_id where H.user_id_me=#{UserId} group by H.user_id_me,H.user_id_my_follow,A.user_name,B.collection_num")
    List<UserFollowDto> findUserFollow(@Param("UserId")String UserId);
}
