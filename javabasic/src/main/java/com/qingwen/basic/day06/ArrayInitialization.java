package com.qingwen.basic.day06;

public class ArrayInitialization {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        for(int i=0; i<intArray.length;i++){
            intArray[i] = i;
        }

        String[] stringArray = new String[20];
        for(int i=0;i<stringArray.length;i++){
            stringArray[i] = "stringArray " + i;
        }
        System.out.println(intArray.length);
        System.out.println(stringArray.length);

        for(int i=0;i<intArray.length;i++)
            System.out.println(intArray[i]);

        for(int i=0;i<stringArray.length;i++)
            System.out.println(stringArray[i]);

    }
}
