package com.qingwen.basic.day09;
//可变形参
public class MethodArgs {
    public static void main(String[] args) {
        MethodA methodA = new MethodA();
        methodA.show("a","---","b");
    }
}

class MethodA{
    public void show(String ... args){
        for(String arg:args) {
            System.out.println(arg);
        }
    }
}
