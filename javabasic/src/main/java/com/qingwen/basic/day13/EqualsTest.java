package com.qingwen.basic.day13;

public class EqualsTest {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        double m = 10.0;
        Integer IntI = 10;
        Integer IntJ = 10;

        System.out.println(i==j);
        System.out.println(i==m);
        System.out.println(IntI.equals(IntJ));
    }
}
