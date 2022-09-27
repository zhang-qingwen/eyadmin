package com.qingwen.basic.day07;

import java.util.Scanner;

public class ArrayExer01 {
    public static void main(String[] args) {
        int[] arr = new int[6];

        arr[0] = (int)(Math.random()*30);

        for (int i = 1;i<arr.length;i++){
            arr[i] = (int)(Math.random()*30);
            for(int j=i-1;j>=0;j--){
                if(arr[i] == arr[j]){
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i< arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
