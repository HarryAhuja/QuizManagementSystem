package com.exam.exceptions;

public class UserNotFoundException extends RuntimeException {

    private String msg;

    public UserNotFoundException()
    {

    }

    public UserNotFoundException(String msg) {
        this.msg = msg;

    }

    public String getMsg() {
        return msg;
    }
}
