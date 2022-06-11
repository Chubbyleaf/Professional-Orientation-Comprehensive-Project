package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.CollectionDao;
import com.example.cloudprovidermusic.entity.Collection;
import com.example.cloudprovidermusic.service.CollectionService;
import org.springframework.stereotype.Service;

/**
 * (Collection)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-05-16 19:23:37
 */
@Service("collectionService")
public class CollectionServiceImpl extends ServiceImpl<CollectionDao, Collection> implements CollectionService {

}

