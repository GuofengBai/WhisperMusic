package com.nju.edu.cn.whispermusic.vo;

public class Response<T> {

    public String status;
    public String message;
    public T data;

    public Response(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(T data) {
        this.status = "OK!";
        this.message = "everything is ok!";
        this.data = data;
    }
}
