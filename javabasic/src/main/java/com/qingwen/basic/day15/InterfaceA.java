package com.qingwen.basic.day15;

public interface InterfaceA {
    public static void out(){
        System.out.println("接口静态方法....");
    }

    default void method01(){
        System.out.println("接口默认方法一....");
    }

    default void method02(){
        System.out.println("接口默认方法二....");
    }

    void method03();
}
