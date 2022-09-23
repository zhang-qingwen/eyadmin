package com.qingwen.basic.day05;
/*
行(i)   列(j)
1
 */

public class LoopTest2 {

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=9;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
