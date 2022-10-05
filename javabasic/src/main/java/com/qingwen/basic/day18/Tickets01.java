package com.qingwen.basic.day18;

/**
 * 创建三个窗口，开始卖票，一共100张
 *
 * @Author qingwen
 * @Create 2022-10-04 23:13
 */
public class Tickets01 {
    public static void main(String[] args) {
        Window window01 = new Window("Window 01: ");
        Window window02 = new Window("Window 02: ");
        Window window03 = new Window("Window 03: ");

        window01.start();
        window02.start();
        window03.start();
    }
}

class Window extends Thread{
    static int totalTicket = 100;
    public void run(){
        for(int i = totalTicket;i>0;i--,totalTicket--){
            System.out.println(this.getName() + "---剩余 - "+ i + " 张票");
        }
    }
    Window(String name){
        super(name);
    }
}
