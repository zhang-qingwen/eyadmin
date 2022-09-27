package com.qingwen.basic.day13;

public class InterviewTest01 {
    public static void main(String[] args) {
        Base base = new sub();
        base.add(1,2,3);
    }
}

class Base {
    public void add(int a, int...arr){
        System.out.println("base");
    }
}

class sub extends Base{
    public void add(int a, int b, int c){
        System.out.println("Sub_2");
    }

    public void add(int a, int[] arr){
        System.out.println("Sub_1");
    }
}