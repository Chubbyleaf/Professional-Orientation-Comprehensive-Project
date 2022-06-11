package org.zyzh.cloudprovideruser.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.entity.UserFollow;
import org.zyzh.cloudprovideruser.sys.entity.UserFollower;
import org.zyzh.cloudprovideruser.sys.vo.FollowVo;

public interface UserRelationService  {
    Result followSomeone(FollowVo followVo);
    Result cancelSomeone(FollowVo followVo);
    Result isFollow(FollowVo followVo);

    User getUserById(String user_id);
    UserFollow getFollowById(String me,String myFollow);
    UserFollower getFollowerById(String mine, String myFollower);
}
