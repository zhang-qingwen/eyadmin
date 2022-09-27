package com.qingwen.basic.day07;

public class BubbleTest {
    public static void main(String[] args) {
        int[] arr1 = new int[]{12,32,41,26,71,28,43,91,101,243};
        int[] arr2 = new int[]{12,32,41,26,71,28,43,91,101,243};

        //选择
        for(int i=0;i< arr1.length;i++){
            for(int j=i+1;j<arr1.length;j++){
                if(arr1[i]>arr1[j]){
                    int temp;
                    temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }

        for(int i=0;i<arr1.length;i++)
            System.out.println(arr1[i]);

        System.out.println();

        //Bubble
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr2.length-i-1;j++){
                if(arr2[j]>arr2[j+1]){
                    int temp;
                    temp = arr2[j];
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp;
                }
            }
        }

        for(int i=0;i<arr2.length;i++)
            System.out.println(arr2[i]);
    }
}
