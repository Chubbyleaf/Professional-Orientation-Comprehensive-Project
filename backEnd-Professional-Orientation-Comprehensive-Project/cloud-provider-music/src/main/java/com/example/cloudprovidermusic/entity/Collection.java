package com.example.cloudprovidermusic.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.util.Date;

/**
 * (Collection)表实体类
 *
 * @author PinkCrow007
 * @since 2022-05-16 19:23:37
 */
@SuppressWarnings("serial")
public class Collection extends Model<Collection> {
    
    private Integer collectionId;
    
    private String collectionName;
    //0公开，1不公开
    private Integer identity;
    
    private String colOwnerId;
    
    private Date createTime;


    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getColOwnerId() {
        return colOwnerId;
    }

    public void setColOwnerId(String colOwnerId) {
        this.colOwnerId = colOwnerId;
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
        return this.collectionId;
    }
    }

