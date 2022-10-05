package com.qingwen.basic.day14;

public class SingletonTest01 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getBankInstance();
        Bank bank2 = Bank.getBankInstance();
        System.out.println(bank1.equals(bank2));
    }
}

class Bank{
    private Bank(){
    }

    private static Bank bankInstance = new Bank();
    public static Bank getBankInstance(){
        return bankInstance;
    }
}