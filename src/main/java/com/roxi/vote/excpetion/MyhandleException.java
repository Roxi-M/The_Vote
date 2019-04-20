package com.roxi.vote.excpetion;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Roxi酱
 */
public class MyhandleException {
    @ExceptionHandler(value = RuntimeException.class)
    public MyException myException(RuntimeException e){
        String s=e.getMessage();
        return new MyException(400,s);
    }
}
