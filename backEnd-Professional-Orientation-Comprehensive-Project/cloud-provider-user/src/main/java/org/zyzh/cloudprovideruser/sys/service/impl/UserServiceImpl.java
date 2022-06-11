package org.zyzh.cloudprovideruser.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.zyzh.cloudprovideruser.framework.utils.BeanConvertUtils;
import org.zyzh.cloudprovideruser.framework.utils.QiNiuUtils;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.dto.UserDisplay;
import org.zyzh.cloudprovideruser.sys.dto.UserFollowDto;
import org.zyzh.cloudprovideruser.sys.dto.UserFollowerDto;
import org.zyzh.cloudprovideruser.sys.entity.UserFollow;
import org.zyzh.cloudprovideruser.sys.entity.UserFollower;
import org.zyzh.cloudprovideruser.sys.mapper.UserFollowMapper;
import org.zyzh.cloudprovideruser.sys.mapper.UserFollowerMapper;
import org.zyzh.cloudprovideruser.sys.mapper.UserMapper;
import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.service.UserService;
import org.zyzh.cloudprovideruser.sys.vo.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.*;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserFollowMapper userFollowMapper;

    @Autowired
    UserFollowerMapper userFollowerMapper;

    @Resource
    private JavaMailSender mailSender;

    private String sendAccount;//接收验证码的账户
    private String sendCode;//验证码
    private Date sendTime;//发送时间

    //	获得.yml文件发件人信息
    @Value("${spring.mail.username}")
    private String from;


    @Override
    public Result login(LoginVo loginVo) {
        User user1 = getById(loginVo.getLoginKey());
        User user2 = getByEmail(loginVo.getLoginKey());
        if (user1 != null) {
            if (user1.getPassword().equals(loginVo.getPassword()))
                if(user1.getIdentity()==1)
                return Result.success("登陆成功");
                else
                    return Result.error(201,"管理员登录");
            else {
                return Result.error(2001, "密码错误");
            }
        } else if (user2 != null) {
            if (user2.getPassword().equals(loginVo.getPassword()))
                if(user2.getIdentity()==1)
                    return Result.success("登陆成功");
                else
                    return Result.error(201,"管理员登录");
            else return Result.error(2001, "密码错误");
        } else {
            return Result.error(2003, "用户不存在");
        }
    }

    @Override
    public Result register(RegisterVo registerVo) {
        User user1 = getById(registerVo.getUserId());
        User user2 = getByEmail(registerVo.getEmail());

        if (user1 != null) return Result.error(2004, "用户id已存在");
        else if (user2 != null) return Result.error(2005, "邮箱已存在");
        else {
            boolean result = this.save(BeanConvertUtils.convertTo(registerVo, User::new));
            if (result) {
                return Result.success("注册成功");
            } else return Result.error(2006, "注册失败");
        }
    }

    @Override
    public Result updateInfo(UpdateInfoVo updateInfoVo) {
        User user = getById(updateInfoVo.getUserId());
        User user2 = getByEmail(updateInfoVo.getEmail());
        if (user != null) {
            if (user2 == null || user.getEmail().equals(updateInfoVo.getEmail())) {
                LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(User::getUserId, updateInfoVo.getUserId());
                User user1 = new User();
                user1.setUserName(updateInfoVo.getUserName());
                user1.setEmail(updateInfoVo.getEmail());
                user1.setAddress(updateInfoVo.getAddress());
                boolean result = this.update(user1, wrapper);
                if (result)
                    return Result.success("用户信息修改成功");
                else
                    return Result.error(2006, "用户信息修改失败");
            } else return Result.error(2007, "邮箱已存在");
        } else
            return Result.error(2008, "用户不存在");
    }

    @Override
    public Result updatePassword(UpdatePasswordVo updatePasswordVo) {
        User user = getById(updatePasswordVo.getUserId());
        if(user==null)
            return Result.error(2002, "用户不存在");
        if (user.getPassword().equals(updatePasswordVo.getOldPass())) {
//            if (updatePasswordVo.getNewPass().equals(updatePasswordVo.getOldPass()))
//                return Result.error(2002, "旧密码与新密码相同");
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUserId, updatePasswordVo.getUserId());
            User user1 = new User();
            user1.setPassword(updatePasswordVo.getNewPass());
            boolean result = this.update(user1, wrapper);
            if (result)
                return Result.success("密码修改成功");
            else
                return Result.error(2001, "密码修改失败");
        } else
            return Result.error(2003, "旧密码错误");
    }

    @Override
    public List findUserFollow(String id) {
        List<UserFollowDto> userFollowList = userFollowMapper.findUserFollow(id);
        return userFollowList;
    }

    @Override
    public List findUserFollower(String id) {
        List<UserFollowerDto> userFollowerList = userFollowerMapper.findUserFollower(id);
        return userFollowerList;
    }

    @Override
    public UserDisplay findUserInfo(String id) {
        User user = getById(id);
        UserDisplay userDisplay = new UserDisplay();
        userDisplay.setUserId(id);
        userDisplay.setUserName(user.getUserName());
        userDisplay.setAddress(user.getAddress());
        userDisplay.setAvatarUrl(user.getAvatarUrl());

        userDisplay.setCreateTime(user.getCreateTime());
        userDisplay.setEmail(user.getEmail());
        userDisplay.setMyFollowNum(getUserFollowNum(id));
        userDisplay.setMyFollowerNum(getUserFollowerNum(id));
        return userDisplay;
    }

    @Override
    public Result uploadPhoto(AvatarVo photoVo) {
        String url;
        try {
            InputStream fileInputStream = photoVo.getFile().getInputStream();
            url = QiNiuUtils.upLoad(fileInputStream, photoVo.getFile().getName());
        } catch (IOException e) {
            e.printStackTrace();
            return Result.error(2001,"上传失败");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserId, photoVo.getUserId());
        User user1 = new User();
        user1.setAvatarUrl(url);
        if (userMapper.update(user1, wrapper) > 0) return Result.success("头像更新成功");
        else return Result.error(2002,"更新用户头像失败");

    }

    @Override
    public Result sendEmail(String userId){
        User user1 = getById(userId);
        String email=user1.getEmail();
        if(email!=null){
            //创建邮件消息
            SimpleMailMessage message = new SimpleMailMessage();
            // 设置发件人
            message.setFrom(from);
            // 设置收件人
            message.setTo(email);
            // 设置邮件标题
            message.setSubject("SoundWave验证");
            String code=randomCode();
            message.setText("【SoundWave】您正在申请重置密码服务\n验证码:"+code+"。\n本验证码5分钟内有效，请及时输入。验证码提供他人可能导致账户被盗，请勿转发或泄露。\n如非本人操作，请忽略该邮件。\n(这是一封自动发送的邮件，请不要直接回复）");

            mailSender.send(message);
            sendTime = new Date();
            sendAccount=userId;
            sendCode=code;
            return Result.success("发送成功");
        }
        else
            return Result.error(2001,"用户不存在");
    }

    @Override
    public Result forgetPassword(ForgetPasswordVo forgetPasswordVo){
        Date date = new Date();
        if(!forgetPasswordVo.getUserId().equals(sendAccount))
            return Result.error(2001,"重置密码账户与接收验证码邮件账户不一致！");
        else if(getMinute(sendTime, date) > 5)
            return Result.error(2002,"验证码已失效！");
        else if(!sendCode.equals(forgetPasswordVo.getValid()))
            return Result.error(2003,"验证码错误！");
        else{
            //User user = getById(forgetPasswordVo.getUserId());
            LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(User::getUserId, forgetPasswordVo.getUserId());
            User user1 = new User();
            user1.setPassword(forgetPasswordVo.getNewPassword());
            boolean result = this.update(user1, wrapper);
            if (result)
                return Result.success("密码重置成功");
            else
                return Result.error(2004, "密码重置失败");
        }
    }



    @Override
    public String randomCode(){
        StringBuilder str = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }

    @Override
    public int getMinute(Date fromDate, Date toDate) {
        return (int) (toDate.getTime() - fromDate.getTime()) / (60 * 1000);
    }


    @Override
    public User getById(String user_id) {
        LambdaQueryWrapper<User> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(User::getUserId, user_id);
        return userMapper.selectOne(wrapper1);
    }

    @Override
    public User getByEmail(String email) {
        LambdaQueryWrapper<User> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(User::getEmail, email);
        return userMapper.selectOne(wrapper1);
    }

    @Override
    public String getUserFollowNum(String id){
        LambdaQueryWrapper<UserFollow> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(UserFollow::getUserIdMe, id);
        String num= String.valueOf(userFollowMapper.selectCount(wrapper1));
        return num;
    }

    @Override
    public String getUserFollowerNum(String id){
        LambdaQueryWrapper<UserFollower> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(UserFollower::getUserIdMine, id);
        String num= String.valueOf(userFollowerMapper.selectCount(wrapper1));
        return num;
    }

}
