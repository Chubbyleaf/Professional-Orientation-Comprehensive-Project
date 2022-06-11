package org.zyzh.cloudprovideruser.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterVo {
    //注册时的id
    @NotEmpty(message = "帐号不能为空！")
    private String userId;
    //注册密码
    @NotEmpty(message = "密码不能为空！")
    private String password;

    @NotEmpty(message = "昵称不能为空！")
    private String userName;

    @NotEmpty(message = "邮箱不能为空！")
    private String email;

}
