package com.qingwen.basic.day13;

public class InterviewTest2 {
    public static void main(String[] args) {
        //类型统一
        Object obj1 = true?new Integer(1):new Double(2.0);
        System.out.println(obj1); //1.0

        Object obj2;
        if(true){
            obj2 = new Integer(1);
        }else
            obj2 = new Double(2.0);
        System.out.println(obj2); //1
    }
}
