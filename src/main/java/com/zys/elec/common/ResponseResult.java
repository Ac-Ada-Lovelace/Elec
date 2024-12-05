package com.zys.elec.common;
import lombok.Data;
@Data
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResponseResult<T> success(String message) {
        return new ResponseResult<>(200, message, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(200, "操作成功", data);
    }

    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<>(400, message, null);
    }

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> failure(String message) {
        return new ResponseResult<>(400, message, null);
    }
}
