package com.example.cloudprovidermusic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermusic.dao.MessageDao;
import com.example.cloudprovidermusic.entity.Message;
import com.example.cloudprovidermusic.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * (Message)表服务实现类
 *
 * @author PinkCrow007
 * @since 2022-05-16 16:43:31
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {

}

