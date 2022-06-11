package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.AnnounceDao;
import com.example.cloudprovidermusic.entity.Announce;
import com.example.cloudprovidermusic.service.AnnounceService;
import org.springframework.stereotype.Service;

/**
 * (Announce)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-05-15 23:03:56
 */
@Service("announceService")
public class AnnounceServiceImpl extends ServiceImpl<AnnounceDao, Announce> implements AnnounceService {

}

