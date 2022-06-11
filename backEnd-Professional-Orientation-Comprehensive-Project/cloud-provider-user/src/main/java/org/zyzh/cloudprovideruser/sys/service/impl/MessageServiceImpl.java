package org.zyzh.cloudprovideruser.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.entity.Message;

import org.zyzh.cloudprovideruser.sys.entity.User;
import org.zyzh.cloudprovideruser.sys.mapper.MessageMapper;
import org.zyzh.cloudprovideruser.sys.mapper.UserMapper;
import org.zyzh.cloudprovideruser.sys.service.MessageService;

import java.util.HashMap;
import java.util.List;


@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    MessageMapper messageMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Result findUserMsgList(String id) {
        if (isUserExist(id)) {
            return Result.success(getUserMsgList(id));
        } else
            return Result.error(2001, "用户不存在");
    }

    @Override
    public Result updateMsgState(String msg_id,Integer state) {
        Message message = getMsgByMsgId(msg_id);
        if (message != null) {

                LambdaQueryWrapper<Message> wrapper = new LambdaQueryWrapper<>();
                wrapper.eq(Message::getMessageId, msg_id);
                Message message1 = new Message();
                message1.setIsRead(state);
                boolean result = this.update(message1, wrapper);
                if (result)
                    return Result.success("修改成功");
                else
                    return Result.error(2002, "修改失败");

        } else
            return Result.error(2001, "该消息不存在");
    }

    @Override
    public Result deleteMsgState(String id){
        Message message = getMsgByMsgId(id);
        if (message != null) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("message_id", id);
            Integer result1 = messageMapper.deleteByMap(map1);
            if (result1 != 1)
                return Result.error(2002, "删除失败");
            else
                return Result.success("删除成功");
        } else
            return Result.error(2001, "该消息不存在");
    }

    @Override
    public List<Message> getUserMsgList(String user_id) {
        LambdaQueryWrapper<Message> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(Message::getMUserId, user_id);
        return messageMapper.selectList(wrapper1);
    }

    @Override
    public Message getMsgByMsgId(String msg_id) {
        LambdaQueryWrapper<Message> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(Message::getMessageId, msg_id);
        return messageMapper.selectOne(wrapper1);
    }

    @Override
    public Boolean isUserExist(String id) {
        LambdaQueryWrapper<User> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(User::getUserId, id);
        if (userMapper.selectOne(wrapper1) != null)
            return true;
        else
            return false;
    }
}
