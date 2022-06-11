package com.example.cloudprovidermusic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.cloudprovidermusic.dto.CommentWithUser;
import com.example.cloudprovidermusic.entity.Comment;

import java.util.List;

/**
 * (Comment)表服务接口
 *
 * @author PinkCrow007
 * @since 2022-05-11 09:09:11
 */
public interface CommentService extends IService<Comment> {
    public List<CommentWithUser> findAll(int audioId);
}

