package com.qingwen.basic.day19;

/**
 * @Author qingwen
 * @Create 2022-10-05 16:09
 */
public class SingletonModel {
    public static void main(String[] args) {
        SingleInstance singleInstance1 = SingleInstance.getInstance();
        SingleInstance singleInstance2 = SingleInstance.getInstance();
        System.out.println(singleInstance1);
        System.out.println(singleInstance2);
        System.out.println(singleInstance1 == singleInstance2);
    }
}

class SingleInstance {
    private static SingleInstance singleInstance;

    private SingleInstance() {
    }

    public static SingleInstance getInstance() {
        synchronized (SingleInstance.class) {
            if (singleInstance == null) {
                singleInstance = new SingleInstance();
                return singleInstance;
            } else
                return singleInstance;
        }
    }
}