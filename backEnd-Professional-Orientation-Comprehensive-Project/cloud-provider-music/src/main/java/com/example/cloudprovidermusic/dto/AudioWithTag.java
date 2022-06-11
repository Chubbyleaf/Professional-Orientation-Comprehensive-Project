package com.example.cloudprovidermusic.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.example.cloudprovidermusic.entity.AudioPublic;
import com.example.cloudprovidermusic.entity.Tag;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class AudioWithTag extends AudioPublic {


    private List<Tag> tagList;




    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}

