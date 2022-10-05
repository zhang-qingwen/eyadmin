package com.qingwen.basic.day17.service;

public class TeamException extends Exception{
    static final Long serialVersionUID = -3387514229948L;

    public TeamException(){
    }

    public TeamException(String msg){
        System.out.println(msg);
    }
}
