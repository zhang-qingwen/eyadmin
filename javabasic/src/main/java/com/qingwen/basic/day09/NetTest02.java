package com.qingwen.basic.day09;

public class NetTest02 {

    public static void main(String[] args) {
        int[] arr = new int[] {12,3,3,34,56,77,432};

        arr = createNewArray(arr);
        for(int a:arr){
            System.out.println(a);
        }
    }

    private static int[] createNewArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            newArr[i] = arr[i]/arr[0];
        }
        return newArr;
    }
}
