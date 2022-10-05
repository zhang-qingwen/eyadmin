package com.qingwen.basic.day14;

public class OrderTest {
    public static void main(String[] args) {
        Order1 order = new Order1();
        System.out.println(order.orderId);
    }
}

class Order1{
    {
        orderId = 4;
    }

    int orderId = 3;

}
