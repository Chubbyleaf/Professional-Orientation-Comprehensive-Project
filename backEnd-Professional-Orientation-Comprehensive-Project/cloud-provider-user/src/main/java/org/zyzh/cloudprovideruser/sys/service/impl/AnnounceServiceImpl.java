package org.zyzh.cloudprovideruser.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyzh.cloudprovideruser.sys.entity.Announce;
import org.zyzh.cloudprovideruser.sys.mapper.AnnounceMapper;
import org.zyzh.cloudprovideruser.sys.service.AnnounceService;


import java.util.List;


@Service
public class AnnounceServiceImpl extends ServiceImpl<AnnounceMapper, Announce> implements AnnounceService {
    @Autowired
    AnnounceMapper announceMapper;

    @Override
    public List<Announce> getAnnList() {
        LambdaQueryWrapper<Announce> wrapper1 = new LambdaQueryWrapper<>();

        return announceMapper.selectList(wrapper1);
    }

}
