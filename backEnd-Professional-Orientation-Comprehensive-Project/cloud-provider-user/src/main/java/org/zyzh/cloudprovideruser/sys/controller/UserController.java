package org.zyzh.cloudprovideruser.sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.dto.UserDisplay;
import org.zyzh.cloudprovideruser.sys.service.UserService;
import org.zyzh.cloudprovideruser.sys.vo.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result Login(@Validated@RequestBody LoginVo loginVo)
    {
        return userService.login(loginVo);
    }

    @PostMapping("/register")
    public Result Register(@Validated@RequestBody RegisterVo registerVo)
    {
        return userService.register(registerVo);
    }

    @PostMapping("/updateUserInfo")
    public Result UpdateInfo(@Validated@RequestBody UpdateInfoVo updateInfoVo)
    {
        return userService.updateInfo(updateInfoVo);
    }

    @PostMapping("/updatePassword")
    public Result UpdateInfo(@Validated@RequestBody UpdatePasswordVo updatePasswordVo)
    {
        return userService.updatePassword(updatePasswordVo);
    }

    @GetMapping("/myFollow")
    public List findUserFollow(@RequestParam @Valid @NotEmpty String userId) {
        return userService.findUserFollow(userId);
    }

    @GetMapping("/myFollower")
    public List findUserFollower(@RequestParam @Valid @NotEmpty String userId) {
        return userService.findUserFollower(userId);
    }

    @GetMapping("/info")
    public UserDisplay findUserInfo(@RequestParam @Valid @NotEmpty String userId) {
        return userService.findUserInfo(userId);
    }

    @PatchMapping("/uploadAvatar")
    public Result photoUpload(@Validated AvatarVo photoVo)
    {
        return userService.uploadPhoto(photoVo);
    }

    @GetMapping("/sendEmail")
    public Result sendEmail(@RequestParam @Valid @NotEmpty String userId)
    {
        return userService.sendEmail(userId);
    }

    @PostMapping("/forgetPassword")
    public Result forgetPassword(@Validated@RequestBody ForgetPasswordVo forgetPasswordVo)
    {
        return userService.forgetPassword(forgetPasswordVo);
    }
}
