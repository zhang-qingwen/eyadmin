package com.qingwen.basic.day09;

public class NetTest01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        method(a, b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    private static void method(int a, int b) {
        Integer intA = (Integer) a;
        Integer intB = (Integer) b;

        intA = intA * 10;
        intB = intB * 20;


    }
}
