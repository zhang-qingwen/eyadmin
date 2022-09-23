package com.qingwen.basic.day05;

public class ForTest2 {
    public static void main(String[] args) {
        for(int i=100;i<1000;i++){
            //百位，121/100=1；十位：121%100=21，21/10 = 2；个位：121%10=1
            if(i==Math.pow(i/100,3)+Math.pow(i%100/10,3)+Math.pow(i%10,3))
                System.out.println(i);
        }
    }
}
