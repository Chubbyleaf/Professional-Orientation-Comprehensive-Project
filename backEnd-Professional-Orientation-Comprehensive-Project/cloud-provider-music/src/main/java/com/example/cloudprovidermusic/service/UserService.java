package com.example.cloudprovidermusic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cloudprovidermusic.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author PinkCrow007
 * @since 2022-04-26 18:37:18
 */
public interface UserService extends IService<User> {
    List<User> topUser();
}

