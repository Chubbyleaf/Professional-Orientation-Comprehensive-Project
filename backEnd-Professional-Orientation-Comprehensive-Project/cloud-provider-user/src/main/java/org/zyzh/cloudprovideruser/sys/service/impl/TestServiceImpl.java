package org.zyzh.cloudprovideruser.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyzh.cloudprovideruser.sys.mapper.UserMapper;
import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.service.TestService;

import java.util.List;
import java.util.concurrent.locks.StampedLock;

@Service
public class TestServiceImpl extends ServiceImpl<UserMapper, User> implements TestService {
    private final StampedLock sl = new StampedLock();


    @Autowired
    UserMapper userMapper;

    @Override
    public String getHello() {
        return "hello world";
    }

    @Override
    public String getString(String s) {
        return "hello"+s;
    }

    @Override
    public List<User> getAll(){
        System.out.println(userMapper.selectList(null));
        return userMapper.selectList(null);
    }

    @Override
    public User getSpecific(String id){
        System.out.println(userMapper.selectById(id));
        return userMapper.selectById(id);

    }

    @Override
    public User getById(String id){
        LambdaQueryWrapper<User> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(User::getUserId, id);
        return userMapper.selectOne(wrapper1);
    }

}
