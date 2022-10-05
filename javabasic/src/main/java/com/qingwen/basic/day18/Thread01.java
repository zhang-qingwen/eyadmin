package com.qingwen.basic.day18;

/**
 * Thread创建的第一种方法
 * @Author qingwen
 * @Create 2022-10-04 11:12
 */
public class Thread01 extends PrimeThread {
    public static void main(String[] args) {
        PrimeThread primeThread = new PrimeThread();
        primeThread.start();

        for(int i=0;i<1000;i++){
            System.out.println("main method " + i);
        }
    }
}

class PrimeThread extends Thread {
    public void run() {
        for(int i=0;i<100;i++)
            System.out.println("thread method " + i);
    }
}