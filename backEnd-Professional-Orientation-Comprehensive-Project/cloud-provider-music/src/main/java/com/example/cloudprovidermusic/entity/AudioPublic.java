package com.example.cloudprovidermusic.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (AudioPublic)表实体类
 *
 * @author PinkCrow007
 * @since 2022-04-19 23:02:31
 */
@SuppressWarnings("serial")
public class AudioPublic extends Model<AudioPublic> {
    @TableId(value = "audio_id")
    private Integer audioId;
    
    private String audioName;
    //审核状态，0:通过，1:不通过，2:待审核
    private Integer status;
    //审核意见
    private String comment;
    
    private Date createTime;
    //描述
    private String des;
    
    private String audioUrl;
    
    private String imgUrl;
    //0:允许下载，1:不允许下载
    private Integer identity;
    
    private String apubAuthorId;

//    private List<Tag> tagList;


    public Integer getAudioId() {
        return audioId;
    }

    public void setAudioId(Integer audioId) {
        this.audioId = audioId;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getApubAuthorId() {
        return apubAuthorId;
    }

    public void setApubAuthorId(String apubAuthorId) {
        this.apubAuthorId = apubAuthorId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.audioId;
    }

//    public List<Tag> getTagList() {
//        return tagList;
//    }
//
//    public void setTagList(List<Tag> tagList) {
//        this.tagList = tagList;
//    }
}

