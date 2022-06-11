package com.example.cloudprovidermusic.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cloudprovidermusic.dto.AudioComplete;
import com.example.cloudprovidermusic.dto.AudioWithTag;
import com.example.cloudprovidermusic.entity.AudioPublic;
import com.example.cloudprovidermusic.entity.Collection;


import java.util.List;

/**
 * (AudioPublic)表服务接口
 *
 * @author PinkCrow007
 * @since 2022-04-19 23:02:31
 */
public interface AudioPublicService extends IService<AudioPublic> {
    List<AudioWithTag> getNameAndTag( QueryWrapper wrapper);
    List<AudioComplete> findFullByAudioId(int audioId);
    List<Collection>findCollectionByAudioIdAndUserId(int audioId, String userId);
    List<AudioWithTag>topMusic();
}

