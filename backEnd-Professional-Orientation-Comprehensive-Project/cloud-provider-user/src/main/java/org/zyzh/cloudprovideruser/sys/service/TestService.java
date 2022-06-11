package org.zyzh.cloudprovideruser.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zyzh.cloudprovideruser.sys.entity.User;

import java.util.List;

public interface TestService extends IService<User> {
    String getHello();
    String getString(String s);
    List<User> getAll();
    User getSpecific(String id);

    User getById(String id);
}
