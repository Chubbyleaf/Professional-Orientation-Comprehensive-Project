package org.zyzh.cloudprovideruser.sys.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDisplay {
    private String userId;

    private String userName;

    private String avatarUrl;

    private String address;
    private String email;

    private Timestamp createTime;

    private String myFollowNum;

    private String myFollowerNum;


}
