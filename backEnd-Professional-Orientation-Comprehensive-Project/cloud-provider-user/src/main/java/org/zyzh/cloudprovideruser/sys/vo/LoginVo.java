package org.zyzh.cloudprovideruser.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginVo {
    //登陆时的手机号或邮箱
    @NotEmpty(message = "帐号不能为空！")
    private String loginKey;
    //密码
    @NotEmpty(message = "密码不能为空！")
    private String password;
}
