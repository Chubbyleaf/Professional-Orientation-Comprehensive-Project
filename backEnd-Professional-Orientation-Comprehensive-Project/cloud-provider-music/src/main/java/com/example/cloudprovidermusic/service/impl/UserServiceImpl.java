package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.UserDao;
import com.example.cloudprovidermusic.entity.User;
import com.example.cloudprovidermusic.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-04-26 18:37:18
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Resource
    UserDao userDao;
    @Override
    public List<User> topUser(){
        return userDao.topUser();
    }
}

