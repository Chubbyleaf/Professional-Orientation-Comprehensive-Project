package org.zyzh.cloudprovideruser.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.entity.UserFollow;
import org.zyzh.cloudprovideruser.sys.entity.UserFollower;
import org.zyzh.cloudprovideruser.sys.mapper.UserFollowMapper;
import org.zyzh.cloudprovideruser.sys.mapper.UserFollowerMapper;
import org.zyzh.cloudprovideruser.sys.mapper.UserMapper;
import org.zyzh.cloudprovideruser.sys.service.UserRelationService;
import org.zyzh.cloudprovideruser.sys.vo.FollowVo;

import java.util.HashMap;

@Service
public class UserRelationServiceImpl implements UserRelationService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserFollowMapper userFollowMapper;

    @Autowired
    UserFollowerMapper userFollowerMapper;

    @Override
    public Result followSomeone(FollowVo followVo) {
        String me = followVo.getMeId();
        String myFollow = followVo.getMyFollowId();
        if (me.equals(myFollow))
            return Result.error(2004, "不能关注自己");

        User user1 = getUserById(me);
        User user2 = getUserById(myFollow);

        if (user1 != null && user2 != null) {
            UserFollow userFollow = getFollowById(me, myFollow);
            if (userFollow == null) {
                UserFollow userFollow1 = new UserFollow();
                userFollow1.setUserIdMe(me);
                userFollow1.setUserIdMyFollow(myFollow);
                Integer result1 = userFollowMapper.insert(userFollow1);

                UserFollower userFollower = new UserFollower();
                userFollower.setUserIdMine(myFollow);
                userFollower.setUserIdMyFollower(me);
                Integer result2 = userFollowerMapper.insert(userFollower);

                if (result1 != 1 || result2 != 1)
                    return Result.error(2002, "插入失败");
                else
                    return Result.success("插入成功");
            } else
                return Result.error(2003, "已关注");
        }
        else
            return Result.error(2005, "用户不存在");
    }

    @Override
    public Result cancelSomeone(FollowVo followVo){
        String me = followVo.getMeId();
        String myFollow = followVo.getMyFollowId();
        if (me.equals(myFollow))
            return Result.error(2004, "不能取关自己");

        User user1 = getUserById(me);
        User user2 = getUserById(myFollow);

        if (user1 != null && user2 != null) {
            UserFollow userFollow = getFollowById(me, myFollow);
            if (userFollow != null) {
                HashMap<String, Object> map1 = new HashMap<>();
                map1.put("user_id_me", me);
                map1.put("user_id_my_follow", myFollow);
                Integer result1 = userFollowMapper.deleteByMap(map1);

                HashMap<String, Object> map2 = new HashMap<>();
                map2.put("user_id_mine", myFollow);
                map2.put("user_id_my_follower", me);
                Integer result2 = userFollowerMapper.deleteByMap(map2);

                if (result1 != 1 || result2 != 1)
                    return Result.error(2002, "删除失败");
                else
                    return Result.success("删除成功");
            } else
                return Result.error(2003, "未关注");
        }
        else
            return Result.error(2005, "用户不存在");

    }

    @Override
    public Result isFollow(FollowVo followVo){
        String me = followVo.getMeId();
        String myFollow = followVo.getMyFollowId();

        User user1 = getUserById(me);
        User user2 = getUserById(myFollow);

        if (user1 != null && user2 != null) {
            UserFollow userFollow = getFollowById(me, myFollow);
            if (userFollow != null) {
                return Result.success(true);
            } else
                return Result.success(false);
        }
        else
            return Result.error(2005, "用户不存在");

    }

    @Override
    public User getUserById(String user_id) {
        LambdaQueryWrapper<User> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(User::getUserId, user_id);
        return userMapper.selectOne(wrapper1);
    }

    @Override
    public UserFollow getFollowById(String me, String myFollow) {
        LambdaQueryWrapper<UserFollow> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.and(wq -> wq.eq(UserFollow::getUserIdMe, me).eq(UserFollow::getUserIdMyFollow, myFollow));
        return userFollowMapper.selectOne(wrapper1);
    }

    @Override
    public UserFollower getFollowerById(String mine, String myFollower) {
        LambdaQueryWrapper<UserFollower> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.and(wq -> wq.eq(UserFollower::getUserIdMine, mine).eq(UserFollower::getUserIdMyFollower, myFollower));
        return userFollowerMapper.selectOne(wrapper1);
    }
}
