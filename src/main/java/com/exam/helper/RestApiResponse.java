package com.exam.helper;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class RestApiResponse
{
    public String status;
    public String msg;
    public Object data;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDateTime timeStamp;

    public RestApiResponse()
    {
        timeStamp=LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public RestApiResponse(String status, String msg, Object data) {
        this();
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public RestApiResponse(String status, String msg) {
        this();
        this.status = status;
        this.msg = msg;
    }


}
