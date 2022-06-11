package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.AudioPublicDao;
import com.example.cloudprovidermusic.dao.TagDao;
import com.example.cloudprovidermusic.dto.AudioWithTag;
import com.example.cloudprovidermusic.entity.Tag;
import com.example.cloudprovidermusic.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Tag)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-04-26 23:48:05
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagDao, Tag> implements TagService {
//    @Resource
//    TagDao tagDao;
//    @Override
//    public List<AudioWithTag> getNameAndTag(QueryWrapper wrapper) {
//        return audioPublicDao.findAudioAndTag(wrapper);
//    }
}

