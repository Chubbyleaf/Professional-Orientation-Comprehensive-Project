package org.zyzh.cloudprovideruser.sys.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserFollowerDto {
    @NotEmpty(message = "帐号不能为空！")
    private String userId;

    //private String userName;

    private String myFollowerId;

    private String myFollowerName;

    private String myFollowerAvatar;

    private String myFollowerFollowerNum="0";//我关注的人的粉丝数

    private String myFollowerCollectionNum="0";//我关注的人的音频数
}
