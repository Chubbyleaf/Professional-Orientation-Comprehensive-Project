package com.example.cloudprovidermaker.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WareHouseSchema implements Serializable {
    @TableId(value = "warehouse_id")
    private Integer warehouse_id;

    private String warehouse_name;
    private Date create_time;
    private String w_owner_id;

}
