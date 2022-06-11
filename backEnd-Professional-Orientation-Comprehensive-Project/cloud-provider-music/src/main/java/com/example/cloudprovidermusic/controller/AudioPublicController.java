package com.example.cloudprovidermusic.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cloudprovidermusic.dto.AudioWithTag;
import com.example.cloudprovidermusic.entity.Announce;
import com.example.cloudprovidermusic.entity.AudioPublic;
import com.example.cloudprovidermusic.entity.Message;
import com.example.cloudprovidermusic.entity.Tag;
import com.example.cloudprovidermusic.service.AudioPublicService;
//import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import com.example.cloudprovidermusic.service.MessageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * (AudioPublic)表控制层
 *
 * @author PinkCrow007
 * @since 2022-04-19 23:02:31
 */
@Api(tags="audioPublic")
@RestController
@RequestMapping("audioPublic")
public class AudioPublicController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private AudioPublicService audioPublicService;
    @Autowired
    private MessageService messageService;
    /**
     * 根据音乐名称和标签名模糊搜索音乐
     *
     * @param name 音乐名
     * @param tagId 标签id
     * @return
     */
    @GetMapping("/selectByNameAndTag")
    public R selectByNameAndTag(Integer current, Integer size,String name, String tagId) {
        System.out.println(name);
        System.out.println(tagId);
//        List<AudioWithTag> audioWithTags=this.audioPublicService.getNameAndTag();
        QueryWrapper<AudioWithTag> wrapper =new QueryWrapper <>();
        wrapper.like(StringUtils.isNotBlank(name), "audio_name", name);
//        wrapper.eq("identity",0);
        wrapper.eq("status",0);
        List<AudioWithTag> audioWithTags=this.audioPublicService.getNameAndTag(wrapper);
        //筛选标签
        if(StringUtils.isNotBlank(tagId))
            audioWithTags=audioWithTags.stream().filter(audio->{
                List<Tag>tempList=audio.getTagList();
                boolean flg=false;
            for(int i=0;i<tempList.size();i++){
                if(tagId.equals(tempList.get(i).getTagId().toString())){
                    flg=true;break;
                }
            }
            return flg;
        }).collect(Collectors.toList());
        int count = audioWithTags.size();
        Page<AudioWithTag> page = new Page<>(current,size);
        List<AudioWithTag> pageList = new ArrayList<>();
//计算当前页第一条数据的下标
        int currId = current>1 ? (current-1)*size:0;
        for (int i=0; i<size && i<count - currId;i++){
            pageList.add(audioWithTags.get(currId+i));
        }
        page.setPages(count %10 == 0 ? count/10 :count/10+1);
        page.setRecords(pageList);
        page.setTotal(audioWithTags.size());

//        wrapper.eq("")
//        LambdaQueryWrapper<AudioPublic> wrapper =new LambdaQueryWrapper <> (audioPublic);
        //wrapper.like(StringUtils.isNotBlank(AudioPublic.()), "NAME", user.getName());
        return success(page);
    }

    /**
     * 根据id获得音乐，包括标签、上传者用户名、头像
     * @param audioId 音乐id
     * @return
     */
    @GetMapping("/selectFullAudioById")
    public R selectFullAudioById(String audioId) {
        return success(this.audioPublicService.findFullByAudioId(Integer.parseInt(audioId)));
    }
    @GetMapping("/topAudio")
    public R topAudio() {
        return success(this.audioPublicService.topMusic());
    }
    /**
     * 某首音乐在用户的哪些收藏夹中
     * @param audioId
     * @param userId
     * @return
     */
    @GetMapping("/findCollectionByAudioIdAndUserId")
    public R findCollectionByAudioIdAndUserId(Integer audioId,String userId) {
        return success(this.audioPublicService.findCollectionByAudioIdAndUserId(audioId,userId));
    }
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param audioPublic 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<AudioPublic> page, AudioPublic audioPublic) {

        //LambdaQueryWrapper<AudioPublic> wrapper =new LambdaQueryWrapper <> (audioPublic);
        //wrapper.like(StringUtils.isNotBlank(AudioPublic.()), "NAME", user.getName());
        return success(this.audioPublicService.page(page, new QueryWrapper<>(audioPublic)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.audioPublicService.getById(id));
    }
    /**
     * 通过主键查询单条数据
     *
     * @param apubAuthorId 作者id
     * @return 音乐列表
     */
    @GetMapping("/AuthorId/{apubAuthorId}")
    public R selectByAuthorId(@PathVariable Integer apubAuthorId) {
        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("apub_author_id",apubAuthorId);//写表中的列名
        return success(this.audioPublicService.listByMap(columnMap));
    }

    /**
     * 新增数据
     *
     * @param audioPublic 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody AudioPublic audioPublic) {
        return success(this.audioPublicService.save(audioPublic));
    }

    /**
     * 修改数据
     *
     * @param audioPublic 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody AudioPublic audioPublic) {
        Integer toStatus=audioPublic.getStatus();
        try {
            if(!toStatus.equals(this.audioPublicService.getById(audioPublic).getStatus())){
                String title="";
                String content="";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = simpleDateFormat.format(audioPublic.getCreateTime());
                if(toStatus.equals(0)) {
                    title = "审核通过";
                    content = content + "亲爱的用户,您好！您于" + time + "上传的音乐《" + audioPublic.getAudioName()
                            + "》已通过审核。";
                }
                else if((toStatus.equals(1))) {
                    title="审核未通过";
                    content = content + "亲爱的用户，您好！很抱歉，您于" + time + "上传的音乐《" + audioPublic.getAudioName()
                            + "》未通过审核。";
                }
                if(audioPublic.getComment() != null && !audioPublic.getComment().isEmpty())
                    content=content+"审核意见：\n"+audioPublic.getComment();
                Message message=new Message(title,content,audioPublic.getApubAuthorId());
                this.audioPublicService.updateById(audioPublic);
                this.messageService.save(message);
            }
            return success(null);
        }
        catch (Exception e){
            return failed("未知错误");
        }

    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.audioPublicService.removeByIds(idList));
    }
}

