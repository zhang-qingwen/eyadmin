package com.qingwen.basic.day05;

/*
Row     Column      num
*/
public class LoopTest3 {
    public static void main(String[] args) {
        //上半部分
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for(int k = 0; k < i + 1; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
        //下半部分
        for(int i = 4; i > 0; i--){
            for(int j = 0; j < 5 - i; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
