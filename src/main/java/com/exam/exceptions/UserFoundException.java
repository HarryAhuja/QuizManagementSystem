package com.exam.exceptions;

public class UserFoundException  extends  RuntimeException{

    private String msg;

    public UserFoundException()
    {

    }

    public UserFoundException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
