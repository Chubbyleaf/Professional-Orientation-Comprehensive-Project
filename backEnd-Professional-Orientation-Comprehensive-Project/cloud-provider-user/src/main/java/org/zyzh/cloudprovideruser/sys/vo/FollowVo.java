package org.zyzh.cloudprovideruser.sys.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class FollowVo {

    @NotEmpty(message = "帐号不能为空！")
    private String meId;

    @NotEmpty(message = "帐号不能为空！")
    private String myFollowId;
}
