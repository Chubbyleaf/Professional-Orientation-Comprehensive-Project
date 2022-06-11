package com.example.cloudprovidermaker.sys.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AudioPrivateSchema implements Serializable {
    @TableId(value = "audio_id")
    private Integer audio_id;

    private String audio_name;

    private String audio_url;
    private String txt_url;
    private String video_url;
    private String key;

    private Date create_time;

    private String apri_author_id;

    public void setTime(Date format) {
        this.create_time = format;
    }

    public void setName(String name) {
        this.audio_name=name;
    }

    public void setUser_id(String user_id) {
        this.apri_author_id=user_id;
    }

    public String getUser_id() {
        return this.apri_author_id;
    }
}
