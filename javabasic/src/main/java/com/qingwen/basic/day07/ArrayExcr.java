package com.qingwen.basic.day07;

public class ArrayExcr {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3,5,8},{12,9},{7,0,6,4}};
        int total = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j] != 0){
                    total += arr[i][j];
                }
            }
        }
        System.out.println(total);
    }
}
