package com.qingwen.basic.day04;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //如何从键盘获取不同变量
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        System.out.println(num);

        System.out.println("请输入你的姓名：");
        String name = sc.next();
        System.out.println(name);
    }
}
