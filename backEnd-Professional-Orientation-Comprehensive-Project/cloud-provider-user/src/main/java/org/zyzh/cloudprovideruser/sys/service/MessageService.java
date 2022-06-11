package org.zyzh.cloudprovideruser.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.dto.UserDisplay;
import org.zyzh.cloudprovideruser.sys.entity.Message;

import java.util.List;


public interface MessageService extends IService<Message> {

    Result findUserMsgList(String id);
    Result updateMsgState(String id,Integer state);
    Result deleteMsgState(String id);

    List getUserMsgList(String user_id);
    Message getMsgByMsgId(String msg_id);
    Boolean isUserExist(String id);
}
