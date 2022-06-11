package com.example.cloudprovidermusic.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * (Announce)表实体类
 *
 * @author PinkCrow007
 * @since 2022-05-15 23:03:55
 */
@SuppressWarnings("serial")
public class Announce extends Model<Announce> {
    @TableId(value = "announce_id",type = IdType.AUTO)
    private Integer announceId;

    private String content;

    private String title;

    private Date createTime;


    public Integer getAnnounceId() {
        return announceId;
    }

    public void setAnnounceId(Integer announceId) {
        this.announceId = announceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.announceId;
    }
    }

