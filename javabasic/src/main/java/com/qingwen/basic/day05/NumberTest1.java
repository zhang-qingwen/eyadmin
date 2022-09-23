package com.qingwen.basic.day05;

public class NumberTest1 {
    public static void main(String[] args) {
        int total = 0;
        for(int i=1; i<=1000;i++){
            for(int j=1; j<i;j++){
                if(i%j==0) {
                    total = total + j;
                }
            }
            if(total==i)
                System.out.println(i);
            total=0;
        }
    }
}
