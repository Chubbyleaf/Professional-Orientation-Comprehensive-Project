package com.example.cloudprovidermusic.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * (Message)表实体类
 *
 * @author PinkCrow007
 * @since 2022-05-16 16:43:18
 */
@SuppressWarnings("serial")
public class Message extends Model<Message> {
    @TableId(value = "message_id",type = IdType.AUTO)
    private Integer messageId;
    
    private String content;
    
    private String mUserId;
    
    private String title;
    
    private Date createTime;
    //0:未读，1：已读，-1：回收站
    private Integer isRead;

    public Message( String title,String content, String mUserId) {
        this.content = content;
        this.mUserId = mUserId;
        this.title=title;
        this.isRead=0;
    }
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMUserId() {
        return mUserId;
    }

    public void setMUserId(String mUserId) {
        this.mUserId = mUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.messageId;
    }
    }

