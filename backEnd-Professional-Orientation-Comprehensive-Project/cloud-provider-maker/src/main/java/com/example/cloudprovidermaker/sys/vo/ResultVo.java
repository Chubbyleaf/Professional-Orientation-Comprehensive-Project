package com.example.cloudprovidermaker.sys.vo;

import lombok.Data;

@Data
public class ResultVo {
    private Object data;

    public ResultVo(Object list) {
        this.data = list;
    }
}
