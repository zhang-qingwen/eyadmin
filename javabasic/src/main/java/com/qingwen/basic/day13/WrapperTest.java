package com.qingwen.basic.day13;

import org.junit.Test;

public class WrapperTest {
    public static void main(String[] args) {
        int A = 10;
        Integer intA = new Integer(A);

        System.out.println(intA);

        Integer in2 = new Integer("123");
        Integer in3 = new Integer(123);
        System.out.println(in2.equals(in3));
    }

    @Test
    public void test(){
        //自动装箱与自动拆箱
        int number = 10;
        method(number);
    }

    public void method(Object obj){
        System.out.println(obj);
    }
}
