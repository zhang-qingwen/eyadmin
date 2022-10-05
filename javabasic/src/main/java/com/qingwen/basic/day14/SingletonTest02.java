package com.qingwen.basic.day14;

public class SingletonTest02 {
    public static void main(String[] args) {
        Order order1 = Order.getOrderInstance();
        Order order2 = Order.getOrderInstance();

        System.out.println(order1.equals(order2));

    }
}
class Order{
    private Order(){}
    private static Order order = null;
    public static Order getOrderInstance(){

        if(order == null){
            order = new Order();
            return order;
        }else
            return order;
    }
}