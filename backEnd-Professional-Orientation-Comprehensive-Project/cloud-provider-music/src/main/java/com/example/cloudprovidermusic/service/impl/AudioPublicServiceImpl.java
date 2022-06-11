package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.AudioPublicDao;
import com.example.cloudprovidermusic.dto.AudioComplete;
import com.example.cloudprovidermusic.dto.AudioWithTag;
import com.example.cloudprovidermusic.entity.AudioPublic;
import com.example.cloudprovidermusic.entity.Collection;
import com.example.cloudprovidermusic.service.AudioPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AudioPublic)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-04-19 23:02:31
 */
@Service("audioPublicService")
public class AudioPublicServiceImpl extends ServiceImpl<AudioPublicDao, AudioPublic> implements AudioPublicService {
    @Resource
    AudioPublicDao audioPublicDao;
    @Override
    public List<AudioWithTag> getNameAndTag(QueryWrapper wrapper) {
        return audioPublicDao.findAudioAndTag(wrapper);
    }
    @Override
    public List<AudioComplete> findFullByAudioId(int audioId) {
        return audioPublicDao.findFullByAudioId(audioId);
    }
    @Override
    public List<Collection>findCollectionByAudioIdAndUserId(int audioId, String userId){
        return audioPublicDao.findCollectionByAudioIdAndUserId(audioId,userId);
    }
    @Override
    public List<AudioWithTag>topMusic(){
        return audioPublicDao.topMusic();
    };

}

