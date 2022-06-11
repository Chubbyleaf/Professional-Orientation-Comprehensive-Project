package com.music.manage.Controller;


import com.alibaba.fastjson.JSONObject;
import com.music.manage.Model.AudioCollection;
import com.music.manage.Model.AudioCollectionId;
import com.music.manage.Model.Collection;
import com.music.manage.Model.User;
import com.music.manage.Repository.AudioCollectionRepository;
import com.music.manage.Repository.CollectionRepository;
import com.music.manage.Service.CollectionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping("Collection")
@RestController
@CrossOrigin
public class CollectionController {
    @Autowired
    CollectionService collectionService;
    @Autowired
    CollectionRepository collectionRepository;
    @Autowired
    AudioCollectionRepository audioCollectionRepository;

    //添加收藏夹
    @RequestMapping(value ="Add",method = RequestMethod.POST)
    public Object addCollection(@RequestBody CollectionInfo newCollection){
        JSONObject jsonObject = new JSONObject();
        User user=new User();
        String collectionName= newCollection.getCollectionName();
        Integer collectionIdentity= newCollection.getCollectionIdentity();
        Instant createTime=Instant.now();
        user.setId(newCollection.getOwnerId());

        Collection collection=new Collection();
        collection.setCollectionName(collectionName);
        collection.setIdentity(collectionIdentity);
        collection.setColOwner(user);
        collection.setCreateTime(createTime);
        collectionService.addCollection(collection);

        jsonObject.put("collection", newCollection);
        jsonObject.put("message", "成功创建收藏夹！");
        jsonObject.put("status", 1);
        return jsonObject;
    }

    /**
     * 删除收藏夹
     * 1.从collection的表中删除
     * 2.从audio_collection的表中删除
     * @param collectionId
     * @return
     */
    @RequestMapping(value = "Delete", method = RequestMethod.POST)
    public Object deleteCollection(Integer collectionId) {
        JSONObject jsonObject = new JSONObject();
        if (collectionRepository.findCollectionById(collectionId)==null) {
            jsonObject.put("message", "您想要删除的收藏夹不存在，删除失败!");
            jsonObject.put("status", -1);
            return jsonObject;
        }

        //删除收藏夹表的数据+收藏夹和音频表里面的数据
        Collection collection=collectionRepository.findCollectionById(collectionId);
        collectionService.removeCollection(collection);
        jsonObject.put("message", "成功删除收藏夹：" + collection.getCollectionName() + "！收藏夹中的音乐被清空！");
        jsonObject.put("status", 1);
        return jsonObject;
    }

    /**
     * 更新收藏夹信息
     * 1.更改收藏夹名称✔
     * 2.更改收藏夹权限✔
     */
    @RequestMapping(value = "Update", method = RequestMethod.POST)
    public Object updateCollection(@RequestBody CollectionInfo collectionInfo) {
        JSONObject jsonObject = new JSONObject();
        Collection collectionEdited;
        Optional<Collection> targetCollection = collectionRepository.findById(collectionInfo.getCollectionId());
        if (targetCollection==null) {
            jsonObject.put("message", "收藏夹不存在，信息修改失败!");
            jsonObject.put("status", -1);
        } else {
            collectionEdited=targetCollection.get();
            collectionEdited.setCollectionName(collectionInfo.collectionName);
            collectionEdited.setIdentity(collectionInfo.collectionIdentity);
            collectionService.editCollection(collectionEdited);
            jsonObject.put("message","收藏夹信息修改成功！");
            jsonObject.put("status", 1);
        }
        return jsonObject;

    }

    //以userid获取某个人的收藏夹
    @RequestMapping(value = "GetByOwner", method = RequestMethod.GET)
    public Object getCollectionByUser(String ownerId) {
        User user=new User();
        user.setId(ownerId);
        return collectionRepository.findByColOwner(user);
    }


    //添加音乐至收藏夹
    @RequestMapping(value = "AddMusic", method = RequestMethod.POST)
    public Object addMusic(@RequestBody AudioCollectionId music){
        AudioCollection audioCollection=new AudioCollection();
        JSONObject jsonObject = new JSONObject();
        audioCollection.setId(music);
        if(!audioCollectionRepository.findById(music).isPresent()){
            collectionService.addMusicToCollection(audioCollection);
            jsonObject.put("message", "成功将音乐添加至收藏夹！");
            jsonObject.put("status", 1);
        }else {
            jsonObject.put("message", "歌曲已存在！");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }

    //将音乐从收藏夹删除
    @RequestMapping(value = "DeleteMusic", method = RequestMethod.POST)
    public Object deleteMusic(@RequestBody AudioCollectionId music){
        JSONObject jsonObject = new JSONObject();

        if(!audioCollectionRepository.findById(music).isPresent()) {
            jsonObject.put("message", "收藏夹中未找到该音乐！");
            jsonObject.put("status", -1);
        }else{
            collectionService.removeMusicFromCollection(music);
            jsonObject.put("message", "成功将音乐从收藏夹删除！");
            jsonObject.put("status", 1);
        }
        return jsonObject;
    }

    //获取某个收藏夹里面的全部歌单
    @RequestMapping(value = "AllMusic", method = RequestMethod.GET)
    public Object showCollection(Integer collectionId){
        List<JSONObject> jsonObjects = new ArrayList<>();

        List<Object[]> musics = audioCollectionRepository.musicInCollection(collectionId);
        for(Object[] music:musics){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("audioId",music[0]);
            jsonObject.put("audioName",music[1]);
            jsonObject.put("description",music[2]);
            jsonObject.put("audioUrl",music[3]);
            jsonObject.put("imgUrl",music[4]);
            jsonObject.put("userId",music[5]);
            jsonObject.put("userName",music[6]);
            jsonObject.put("download",music[7]);
            jsonObjects.add(jsonObject);
        }
        return jsonObjects;
    }



    @Data
    public static class CollectionInfo{
        private Integer collectionId;
        private String collectionName;
        private Integer collectionIdentity;
        private String ownerId;
    }



}
