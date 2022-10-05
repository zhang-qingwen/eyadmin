package com.qingwen.basic.day18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * @Author qingwen
 * @Create 2022-10-05 15:46
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        NumberThread1 numberThread1 = new NumberThread1();
        executorService.execute(numberThread1);
        executorService.execute(numberThread1);
        executorService.execute(new NumberThread2());
//        executorService.su

        executorService.shutdown();
    }
}

class NumberThread1 implements Runnable{
    public static Object object = new Object();
    public void run(){
        synchronized (object) {
            for (int i = 0; i < 100; i++) {
                if (i % 2 == 0)
                    System.out.println(Thread.currentThread().getName() + "---:" + i);
            }
        }
    }
}

class NumberThread2 implements Runnable{
    public void run(){
        for(int i=0;i<100;i++){
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName() + "---:" + i);
        }
    }
}
