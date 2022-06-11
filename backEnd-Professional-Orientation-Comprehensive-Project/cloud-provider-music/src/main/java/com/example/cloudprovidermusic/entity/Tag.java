package com.example.cloudprovidermusic.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Tag)表实体类
 *
 * @author PinkCrow007
 * @since 2022-04-26 23:48:01
 */
@SuppressWarnings("serial")
public class Tag extends Model<Tag> {
    @TableId(value = "tag_id",type = IdType.AUTO)
    private Integer tagId;
    
    private String tagName;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.tagId;
    }
    }

