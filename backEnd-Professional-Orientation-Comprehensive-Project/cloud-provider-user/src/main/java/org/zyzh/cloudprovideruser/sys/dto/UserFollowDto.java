package org.zyzh.cloudprovideruser.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class UserFollowDto {
    @NotEmpty(message = "帐号不能为空！")
    private String userId;

    //private String userName;

    private String myFollowId;

    private String myFollowName;

    private String myFollowAvatar;

    private String myFollowFollowerNum="0";//我关注的人的粉丝数

    private String myFollowCollectionNum="0";//我关注的人的音频数


}
