package org.zyzh.cloudprovideruser.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ForgetPasswordVo {
    @NotEmpty(message = "帐号不能为空！")
    String userId;

    @NotEmpty(message = "新密码不能为空！")
    String newPassword;

    @NotEmpty(message = "验证码不能为空！")
    String valid;
}
