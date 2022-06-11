package com.example.cloudprovidermaker.sys.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.Date;

public class TxtGetAll {
    @JsonProperty(value = "audio_id")
    Integer audio_id;

    @JsonProperty(value = "audio_name")
    String audio_name;

    @JsonProperty(value = "txt_url")
    String txt_url;

    @JsonProperty(value = "create_time")
    String create_time;

    @JsonProperty(value = "user_id")
    String user_id;


    public Integer getAudio_id() {
        return audio_id;
    }

    public void setAudio_id(Integer audio_id) {
        this.audio_id = audio_id;
    }

    public String getAudio_name() {
        return audio_name;
    }

    public void setAudio_name(String audio_name) {
        this.audio_name = audio_name;
    }

    public String getTxt_url() {
        return txt_url;
    }

    public void setTxt_url(String txt_url) {
        this.txt_url = txt_url;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


}
