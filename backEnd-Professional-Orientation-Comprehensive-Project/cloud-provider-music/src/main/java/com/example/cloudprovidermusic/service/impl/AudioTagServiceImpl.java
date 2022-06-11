package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.AudioTagDao;
import com.example.cloudprovidermusic.entity.AudioTag;
import com.example.cloudprovidermusic.service.AudioTagService;
import org.springframework.stereotype.Service;

/**
 * (AudioTag)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-04-27 02:15:37
 */
@Service("audioTagService")
public class AudioTagServiceImpl extends ServiceImpl<AudioTagDao, AudioTag> implements AudioTagService {

}

