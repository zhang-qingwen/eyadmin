/*
求最大公约数和最小公倍数
 */
package com.qingwen.basic.day05;

import java.util.Scanner;

public class FotTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int firstNum1 = scanner.nextInt();
        System.out.println("请输入第二个数");
        int firstNum2 = scanner.nextInt();

        int min = (firstNum1<firstNum2)?firstNum1:firstNum2;
        for(int i=min;i>=1;i--){
            if(firstNum1%i==0 && firstNum2%i==0) {
                System.out.println("最大公约数是:" + i);
                break;
            }
        }

        int max = (firstNum1<firstNum2)?firstNum2:firstNum1;
        for(int i=max;i<=firstNum1*firstNum2;i++){
            if(i%firstNum1==0&&i%firstNum2==0){
                System.out.println("最小公倍数是:" + i);
                break;
            }
        }
    }
}
