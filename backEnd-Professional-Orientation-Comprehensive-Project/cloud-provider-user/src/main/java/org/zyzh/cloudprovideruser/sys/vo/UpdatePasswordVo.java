package org.zyzh.cloudprovideruser.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UpdatePasswordVo {
    @NotEmpty(message = "id不能为空！")
    private String userId;

    @NotEmpty(message = "旧密码不能为空！")
    private String oldPass;

    @NotEmpty(message = "新密码不能为空！")
    private String newPass;

}
