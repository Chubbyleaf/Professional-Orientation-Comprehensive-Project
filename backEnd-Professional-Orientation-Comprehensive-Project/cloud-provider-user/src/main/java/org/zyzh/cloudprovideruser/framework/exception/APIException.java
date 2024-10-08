package org.zyzh.cloudprovideruser.framework.exception;


import lombok.Getter;
import org.zyzh.cloudprovideruser.framework.enums.AppCode;
import org.zyzh.cloudprovideruser.framework.enums.StatusCode;

@Getter
public class APIException extends RuntimeException {
    private int code;
    private String msg;

    // 手动设置异常
    public APIException(StatusCode statusCode, String message) {
        // message用于用户设置抛出错误详情，例如：当前价格-5，小于0
        super(message);
        // 状态码
        this.code = statusCode.getCode();
        // 状态码配套的msg
        this.msg = statusCode.getMsg();
    }

    // 默认异常使用APP_ERROR状态码
    public APIException(String message) {
        super(message);
        this.code = AppCode.APP_ERROR.getCode();
        this.msg = AppCode.APP_ERROR.getMsg();
    }

    //
    public APIException(StatusCode statusCode){
        super(statusCode.getMsg());
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }
}
