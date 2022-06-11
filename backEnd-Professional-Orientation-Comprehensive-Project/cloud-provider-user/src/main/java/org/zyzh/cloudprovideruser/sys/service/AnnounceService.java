package org.zyzh.cloudprovideruser.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zyzh.cloudprovideruser.sys.entity.Announce;

import java.util.List;


public interface AnnounceService extends IService<Announce> {

    List getAnnList();

}
