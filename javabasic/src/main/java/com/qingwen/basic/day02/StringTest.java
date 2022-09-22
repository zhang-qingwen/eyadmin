package com.qingwen.basic.day02;

public class StringTest {
    public static void main(String[] args) {
        char char_1 = 'c';
        int num = 10;

        String str = "hello";
        System.out.println(char_1 + num + str);
        System.out.println(char_1 + str + num);
        System.out.println(char_1 + (num + str));
        System.out.println((char_1 + num) + str);
        System.out.println(str + num + char_1);
    }
}
