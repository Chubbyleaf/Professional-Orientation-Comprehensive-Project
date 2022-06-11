package org.zyzh.cloudprovideruser.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.dto.UserDisplay;
import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.vo.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface UserService extends IService<User> {
    Result login(LoginVo loginVo);
    Result register(RegisterVo registerVo);
    Result updateInfo(UpdateInfoVo updateInfoVo);
    Result updatePassword(UpdatePasswordVo updatePasswordVo);
    List findUserFollow(String id);
    List findUserFollower(String id);
    UserDisplay findUserInfo(String id);
    Result uploadPhoto(AvatarVo avatarVo);
    Result sendEmail(String userId);
    Result forgetPassword(ForgetPasswordVo forgetPasswordVo);


    String randomCode();
    int getMinute(Date fromDate, Date toDate);

    User getById(String id);
    User getByEmail(String email);
    String getUserFollowNum(String id);
    String getUserFollowerNum(String id);
    //String getUserCollectionNum(String id);
    //String getUserPubAudioNum(String id);


}