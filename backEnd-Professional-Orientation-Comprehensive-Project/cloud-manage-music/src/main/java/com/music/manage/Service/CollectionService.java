package com.music.manage.Service;

import com.music.manage.Model.AudioCollection;
import com.music.manage.Model.AudioCollectionId;
import com.music.manage.Model.Collection;
import com.music.manage.Repository.AudioCollectionRepository;
import com.music.manage.Repository.CollectionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 收藏夹服务类
 */
@Service("CollectionService")
public class CollectionService {
    @Resource
    CollectionRepository collectionRepository;
    @Resource
    AudioCollectionRepository audioCollectionRepository;

    /**
     * 创建收藏夹
     */
    public void addCollection(Collection collection){collectionRepository.save(collection);}

    /**
     * 删除收藏夹/
     */
    public void removeCollection(Collection collection){
        collectionRepository.deleteById(collection.getId());
        audioCollectionRepository.deleteById_AcCollectionId(collection.getId());
    }

    /**
     * 修改收藏夹信息
     */
    public void editCollection(Collection collection){collectionRepository.save(collection);}

    /**
     * 添加音乐至收藏夹
     */
    public void addMusicToCollection(AudioCollection audioCollection){
        audioCollectionRepository.save(audioCollection);
    }

    /**
     * 从收藏夹删除音乐
     */
    public void removeMusicFromCollection(AudioCollectionId audioCollectionId){
        audioCollectionRepository.deleteById(audioCollectionId);
    }

}