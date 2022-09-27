package com.qingwen.basic.day07;
/*
二分查找
 */
public class ArrayExer03 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,19,30,34,56,91,101};

        int check = 2;
        int head = 0;
        int end = arr.length;

        boolean flag = true;

        while(head<=end){
            int middle = (head + end)/2;
            if(arr[middle]==check){
                System.out.println("找到啦, " + middle);
                flag = false;
                break;
            }else if(check>arr[middle]){
                head = middle + 1;
            }else{
                end = middle - 1;
            }
        }
        if(flag == true){
            System.out.println("没找到。。。");
        }
    }
}
