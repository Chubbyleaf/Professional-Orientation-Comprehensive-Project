package com.example.cloudprovidermusic.dto;

import com.example.cloudprovidermusic.entity.Comment;
import lombok.Data;

@Data
public class CommentWithUser extends Comment {
    private String userName;
    private String avatarUrl;
}
