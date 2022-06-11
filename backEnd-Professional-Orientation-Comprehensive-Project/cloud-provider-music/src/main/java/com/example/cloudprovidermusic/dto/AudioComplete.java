package com.example.cloudprovidermusic.dto;

import com.example.cloudprovidermusic.entity.AudioPublic;
import com.example.cloudprovidermusic.entity.Tag;
import lombok.Data;

import java.util.List;
@Data
public class AudioComplete extends AudioPublic {

    private List<Tag> tagList;
    private String authorName;
    private String avatarUrl;
}
