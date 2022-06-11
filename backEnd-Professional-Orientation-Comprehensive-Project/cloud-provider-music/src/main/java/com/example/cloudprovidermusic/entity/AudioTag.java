package com.example.cloudprovidermusic.entity;


import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (AudioTag)表实体类
 *
 * @author PinkCrow007
 * @since 2022-04-27 02:15:35
 */
@SuppressWarnings("serial")
public class AudioTag extends Model<AudioTag> {
    
    private Integer atTagId;
    
    private Integer atAudioPublicId;


    public Integer getAtTagId() {
        return atTagId;
    }

    public void setAtTagId(Integer atTagId) {
        this.atTagId = atTagId;
    }

    public Integer getAtAudioPublicId() {
        return atAudioPublicId;
    }

    public void setAtAudioPublicId(Integer atAudioPublicId) {
        this.atAudioPublicId = atAudioPublicId;
    }

}

