package com.example.cloudprovidermaker.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AudioWareHouseSchema  implements Serializable {
    @TableId(value = "aw_warehouse_id")
    private Integer aw_warehouse_id;

    @TableId(value = "aw_audio_private_id")
    private Integer aw_audio_private_id;
}
