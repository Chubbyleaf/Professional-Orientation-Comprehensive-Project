package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.CommentDao;
import com.example.cloudprovidermusic.dto.CommentWithUser;
import com.example.cloudprovidermusic.entity.Comment;
import com.example.cloudprovidermusic.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-05-11 09:09:11
 */
@Service("commentService")
public class CommentServiceImpl extends ServiceImpl<CommentDao, Comment> implements CommentService {
    @Resource
    CommentDao commentDao;
    @Override
    public List<CommentWithUser> findAll(int audioId){
        return commentDao.findAll(audioId);
    }
}

