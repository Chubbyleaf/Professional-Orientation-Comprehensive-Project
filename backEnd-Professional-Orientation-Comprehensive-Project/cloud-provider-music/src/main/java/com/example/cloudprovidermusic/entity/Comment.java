package com.example.cloudprovidermusic.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * (Comment)表实体类
 *
 * @author PinkCrow007
 * @since 2022-05-11 09:09:11
 */
@SuppressWarnings("serial")
public class Comment extends Model<Comment> {
    @TableId(value = "comment_id",type = IdType.AUTO)
    private Integer commentId;
    
    private String content;
    
    private Date createTime;
    
    private Integer comAudioPublicId;
    
    private String comOwnerId;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getComAudioPublicId() {
        return comAudioPublicId;
    }

    public void setComAudioPublicId(Integer comAudioPublicId) {
        this.comAudioPublicId = comAudioPublicId;
    }

    public String getComOwnerId() {
        return comOwnerId;
    }

    public void setComOwnerId(String comOwnerId) {
        this.comOwnerId = comOwnerId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }
    }

