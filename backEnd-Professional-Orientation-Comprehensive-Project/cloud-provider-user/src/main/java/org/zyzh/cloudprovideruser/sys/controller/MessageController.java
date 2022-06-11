package org.zyzh.cloudprovideruser.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.service.MessageService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/myMessageList")
    public Result findUserFollow(@RequestParam @Valid @NotEmpty String userId) {
        return messageService.findUserMsgList(userId);
    }

    @GetMapping("/changeMsgState")
    public Result changeMsgState(@RequestParam @Valid @NotEmpty String msgId,@RequestParam @Valid @NotEmpty Integer state) {
        return messageService.updateMsgState(msgId,state);
    }

    @GetMapping("/deleteMsg")
    public Result deleteMsg(@RequestParam @Valid @NotEmpty String msgId) {
        return messageService.deleteMsgState(msgId);
    }
}
