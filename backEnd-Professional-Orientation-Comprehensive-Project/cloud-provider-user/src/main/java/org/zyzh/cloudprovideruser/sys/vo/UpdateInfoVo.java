package org.zyzh.cloudprovideruser.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class UpdateInfoVo {
    @NotEmpty(message = "id不能为空！")
    private String userId;

    private String userName;

    private String email;

    private String address;
}
