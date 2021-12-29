package com.exam.exceptions;

public class MethodArgumentNotValidException extends  RuntimeException{
    private String msg;

    public MethodArgumentNotValidException()
    {

    }

    public MethodArgumentNotValidException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
