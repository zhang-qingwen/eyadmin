package com.qingwen.basic.day05;

public class PrimeNumberTest {
    public static void main(String[] args) {
        boolean isFlag = true;
        int m = 0;
        for(int i = 2; i < 20; i++){
            for(int j = 2; j <= Math.sqrt(i)+1; j++){ //优化二
                m++;
                if(i%j==0 && i!=j){
                    isFlag = false;
                    break; //优化一
                }
            }
            if(isFlag==true)
                System.out.println(i);
            isFlag = true;
        }
        System.out.println(m + "次");
    }
}
