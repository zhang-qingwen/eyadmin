package com.qingwen.basic.day13;

public class EqualsPerson {
    public static void main(String[] args) {
        Person A = new Person("zhangsan", 20);
        Person B = new Person("lisi",20);
        System.out.println(A.equals(B));
    }
}
