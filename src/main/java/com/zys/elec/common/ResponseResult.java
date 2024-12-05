package com.zys.elec.common;
import lombok.Data;
@Data
public class ResponseResult {
    private int code;
    private String message;
    private Object data;

    public static ResponseResult success(String message) {
        return new ResponseResult(200, message, null);
    }

    public static ResponseResult success(Object data) {
        return new ResponseResult(200, "操作成功", data);
    }

    public static ResponseResult error(String message) {
        return new ResponseResult(400, message, null);
    }

    public ResponseResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
