package com.example.hfs.simpleapp.base;

/**
 * Created by HFS on 2016/12/7.
 * 数据返回类
 */

public class BaseResponse<T> {
    public static final int FAILURE = 0; // 失败
    public static final int SUCCESS = 1; // 成功

    private int status;  // 返回状态：0 失败   1 成功
    private String message;  // 返回信息
    private T data;  // 包装的对象

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
