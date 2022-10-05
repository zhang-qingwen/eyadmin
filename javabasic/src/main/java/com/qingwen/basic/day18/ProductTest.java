package com.qingwen.basic.day18;

/**
 * @Author qingwen
 * @Create 2022-10-05 14:15
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        Consumer c1 = new Consumer(clerk);
        Consumer c2 = new Consumer(clerk);
        p1.setName("生产者1");
        c1.setName("消费者1");
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }
}

class Clerk{
    private int coffeeCount = 0;

    //生产产品
    public synchronized void produceProduct(){
        coffeeCount++;
        if(coffeeCount < 20){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": 开始生产第"+ coffeeCount + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if(coffeeCount > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": 开始消费第"+ coffeeCount + "个产品");
            coffeeCount--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run(){
//        System.out.println(getName() + ": 开始生产产品");
        while(true) {
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run(){
        System.out.println(getName() + "");
        while(true){
//            System.out.println(getName() + ": 开始消费产品");
            clerk.consumeProduct();
        }
    }
}
