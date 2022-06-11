package org.zyzh.cloudprovideruser.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.service.UserRelationService;
import org.zyzh.cloudprovideruser.sys.service.UserService;
import org.zyzh.cloudprovideruser.sys.vo.FollowVo;


@RestController
@RequestMapping("/user")
public class UserRelationController {
    @Autowired
    UserRelationService userRelationService;

    @PostMapping("/followSomeone")
    public Result Follow(@Validated @RequestBody FollowVo followVo)
    {
        return userRelationService.followSomeone(followVo);
    }

    @PostMapping("/cancelFollowSomeone")
    public Result CancelFollow(@Validated @RequestBody FollowVo followVo)
    {
        return userRelationService.cancelSomeone(followVo);
    }

    @PostMapping("/isFollow")
    public Result IsFollow(@Validated @RequestBody FollowVo followVo)
    {
        return userRelationService.isFollow(followVo);
    }
}
