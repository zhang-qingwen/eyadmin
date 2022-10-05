package com.qingwen.basic.day18;

import java.util.concurrent.locks.Lock;

/**
 * @Author qingwen
 * @Create 2022-10-05 11:33
 */
public class BankSave {
    public static void main(String[] args) {
        BankWindow bankWindow = new BankWindow();

        Thread T1 = new Thread(bankWindow);
        Thread T2 = new Thread(bankWindow);
        T1.setName("储户-1: ");
        T2.setName("储户-2: ");
        T1.start();
        T2.start();
    }
}

class BankWindow implements Runnable{
    public int accountAsset = 0;
    public Object object = new Object();


    @Override
    public void run() {
        for(int i=0;i<3;i++) {
            synchronized (object) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                accountAsset = accountAsset + 1000;
                System.out.println(Thread.currentThread().getName() + ": 存之后余额 - " + accountAsset);
            }
        }
    }
}
