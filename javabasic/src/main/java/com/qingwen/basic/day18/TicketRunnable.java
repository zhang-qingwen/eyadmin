package com.qingwen.basic.day18;

/**
 * @Author qingwen
 * @Create 2022-10-05 10:15
 */
public class TicketRunnable {
    public static void main(String[] args) {
        WindowRunnable window = new WindowRunnable();

        Thread window01 = new Thread(window);
        window01.setName("窗口一：");
        Thread window02 = new Thread(window);
        window02.setName("窗口二：");
        Thread window03 = new Thread(window);
        window03.setName("窗口三：");
        window01.start();
        window02.start();
        window03.start();
    }
}

class WindowRunnable implements Runnable {
    private int ticketCount = 100;
    private static Object o = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (o) {
                if (ticketCount > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "...." + ticketCount);
                    ticketCount--;
                } else {
                    break;
                }
            }
        }
    }
}
