package com.qingwen.basic.day18;

/**
 * @Author qingwen
 * @Create 2022-10-04 21:56
 */
public class Thread02{
    public static void main(String[] args) {
         MyThread01 myThread01 = new MyThread01();
         myThread01.setPriority(Thread.MAX_PRIORITY);
         myThread01.setName("The First Thread ");
         MyThread02 myThread02 = new MyThread02();
         myThread02.setPriority(Thread.MIN_PRIORITY);
         myThread02.setName("The Second Thread ");

         myThread01.start();
         myThread02.start();

    }
}

class MyThread01 extends Thread{
    public void run(){
        for(int i=0;i<100;i++){
            if(i%2==0) {
//                try{
//                    sleep(10);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + "--优先级-" + this.getPriority() + "...偶数..." + i);
            }
//            if(i%20==0) {
//                System.out.println("------Yield方法-----");
//                yield();
//            }
        }

    }
}

class MyThread02 extends Thread{
    public void run(){
        for(int i=0;i<100;i++){
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName() + "--优先级-" + this.getPriority() + "...奇数..." + i);
        }
    }
}

