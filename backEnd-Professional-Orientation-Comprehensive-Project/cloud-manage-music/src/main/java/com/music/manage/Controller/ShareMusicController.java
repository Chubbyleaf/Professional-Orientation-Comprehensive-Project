package com.music.manage.Controller;



import com.alibaba.fastjson.JSONObject;
import com.music.manage.Model.AudioPrivate;

import com.music.manage.Model.AudioPublic;
import com.music.manage.Model.AudioTag;
import com.music.manage.Model.AudioTagPK;
import com.music.manage.Repository.AudioPrivateRepository;

import com.music.manage.Repository.AudioPublicRepository;
import com.music.manage.Repository.AudioTagRepository;
import com.music.manage.Repository.TagRepository;
import com.music.manage.Util.QiNiuUtil;
import lombok.Data;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("ShareMusic")
@RestController
@CrossOrigin
public class ShareMusicController {
    @Autowired
    AudioPublicRepository audioPublicRepository;
    @Autowired
    AudioPrivateRepository audioPrivateRepository;
    @Autowired
    AudioTagRepository audioTagRepository;
    @Autowired
    TagRepository tagRepository;

    //获取全部标签
    @RequestMapping(value = "AllTags",method = RequestMethod.GET)
    public Object getAllTags(){
        return tagRepository.findAll();
    }

    //分享仓库中的音乐
    @RequestMapping(method = RequestMethod.POST)
    public Object shareMusic(@RequestParam Integer audioId,@RequestParam String audioName,@RequestParam String description,@RequestParam Integer identity,@RequestPart("file") MultipartFile file,@RequestParam String tags){
        AudioPublic musicShared=new AudioPublic();
        Optional<AudioPrivate> findMusic=audioPrivateRepository.findById(audioId);
        musicShared.setAudioUrl(findMusic.get().getAudioUrl());
        musicShared.setAudioName(audioName);
        musicShared.setCreateTime(Instant.now());
        musicShared.setApubAuthor(findMusic.get().getApriAuthor());
        musicShared.setDes(description);
        String key = QiNiuUtil.uploadFile(file);//上传图片至七牛云
        musicShared.setImgUrl("http://rcqhtityo.bkt.clouddn.com/" + key);
        musicShared.setStatus(2);//默认待审核中
        //默认不可以下载
        if(identity==null) {
            musicShared.setIdentity(0);
        }else {
            musicShared.setIdentity(identity);
        };
        Integer audioPublicId=audioPublicRepository.save(musicShared).getId();
        System.out.println(11111);
        System.out.println(audioPublicId);
        //数据库添加标签
        if(!tags.isEmpty()) {
            String[] result = tags.split(",");
            for (String tag:result) {
                System.out.println(tag);
                AudioTag audioTag = new AudioTag();
                audioTag.setAtTagId(Integer.parseInt(tag));
                audioTag.setAtAudioPublicId(audioPublicId);
                audioTagRepository.save(audioTag);
            }
        }



        JSONObject jsonObject=new JSONObject();
        jsonObject.put("message","分享成功~");
        jsonObject.put("status",1);
        return jsonObject;
    }

    //获取某个人分享的全部音乐
    @RequestMapping(value = "SomeoneAll",method = RequestMethod.GET)
    public Object getShareMusicByOwner(String ownerId){
        return audioPublicRepository.findByApubAuthor_Id(ownerId);
    }

//    获取某个人分享的某个音乐的标签
    @RequestMapping(value = "GetMusicTag",method = RequestMethod.GET)
    public Object getMusicTag(Integer audioId){
        List<JSONObject> jsonObjects = new ArrayList<>();
        List<Object[]> musicTags = audioTagRepository.findMusicTags(audioId);
        if(!musicTags.isEmpty()){
            for(Object[] music:musicTags){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("tagId",music[0]);
                jsonObject.put("tagName",music[1]);
                jsonObjects.add(jsonObject);
            }
            return jsonObjects;
        }else{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message","查找为空！");
            jsonObject.put("status", -1);
            return jsonObject;
        }
    }

    //删除某个人分享的音乐
    @RequestMapping(value = "Delete",method = RequestMethod.POST)
    public Object deleteMusic(Integer id){
        JSONObject jsonObject = new JSONObject();
        if(!audioPublicRepository.findById(id).isPresent()){
            jsonObject.put("message","音乐不存在");
            jsonObject.put("status", -1);
        }else {
            audioPublicRepository.deleteById(id);
            jsonObject.put("message","删除成功！");
            jsonObject.put("status", 1);
        }
        return jsonObject;
    }


    /**
     * 修改分享的音乐
     * 1.修改名字
     * 2.修改下载权限
     * 3.修改对音乐的描述
     */
    @RequestMapping(value = "Edit",method = RequestMethod.POST)
    public Object editMusic(@RequestBody Music music){
        JSONObject jsonObject = new JSONObject();
        AudioPublic audioPublicEdited;
        Optional<AudioPublic>targetAudio=audioPublicRepository.findById(music.audioId);
        if(targetAudio==null){
            System.out.println(targetAudio.get().getAudioName());
            jsonObject.put("message", "未找到您分享的音乐~");
            jsonObject.put("status", -1);
        }else{
            audioPublicEdited=targetAudio.get();
            audioPublicEdited.setAudioName(music.audioName);
            audioPublicEdited.setIdentity(music.identity);
            audioPublicEdited.setDes(music.description);
            audioPublicRepository.save(audioPublicEdited);
            jsonObject.put("message","修改成功！");
            jsonObject.put("status", 1);
        }
        return jsonObject;
    }

    /**
     * 获取所有public音乐审核通过的音乐
     */
    @RequestMapping(value = "AllPass",method = RequestMethod.POST)
    public Object getAll(){
        return audioPublicRepository.findByStatus(0);
    }

    /**
     * 按歌曲名字查找
     */
    @RequestMapping(value = "Search",method = RequestMethod.POST)
    public Object getByAudioName(String audioName){
        return audioPublicRepository.findByAudioName(audioName.trim());
    }


    @Data
    public static class Music{
        private Integer audioId;
        private String audioName;
        private String description;
        private Integer identity;//默认不可以下载
    }
}