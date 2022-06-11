package org.zyzh.cloudprovideruser.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("user_follower")
public class UserFollower {
    private String userIdMine;

    private String userIdMyFollower;
}
