package com.SpringSecurity.pratice.exception;
public class NotMatchPasswordException extends  RuntimeException{
    public NotMatchPasswordException(String msg, Throwable t){
        super(msg, t);
    }
    public NotMatchPasswordException(String msg){
        super(msg);
    }
    public NotMatchPasswordException(){
        super();
    }
}

