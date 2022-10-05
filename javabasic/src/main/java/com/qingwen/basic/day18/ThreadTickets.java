package com.qingwen.basic.day18;

/**
 * @Author qingwen
 * @Create 2022-10-05 10:42
 */
public class ThreadTickets {

    public int ticketCount = 100;
    Tickets tickets = new Tickets();

//    Window01 window01 = new Window01();

//    window01


}

class Tickets{
    public void sellTicket(int ticketCount){
        for(int i=ticketCount;i>0;i--){
            System.out.println(Thread.currentThread().getName() + "...." + ticketCount);
            ticketCount--;
        }
    }
}