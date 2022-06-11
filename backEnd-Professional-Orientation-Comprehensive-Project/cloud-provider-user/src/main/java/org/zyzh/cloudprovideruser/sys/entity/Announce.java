package org.zyzh.cloudprovideruser.sys.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

//网络通信 一定要实现序列化
//使用lombok
// 微服务 一个服务对应一个数据库，同一个信息可能存在不同的数据库
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName("announce")
public class Announce implements Serializable{
    //主键
    @TableId(value="announce_id",type= IdType.AUTO)
    private Integer announceId;

    //非主键
    private String content;

    private String title;

    private Timestamp createTime;


}
