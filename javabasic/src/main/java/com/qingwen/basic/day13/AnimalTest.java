package com.qingwen.basic.day13;

public class AnimalTest {
    public static void main(String[] args) {
        Animal animal1 = new Animal("Name1","Type1");

        System.out.println(animal1.toString());

        Animal animal2 = new Animal("Name2","Type2");

        System.out.println(animal2.toString());

        System.out.println(animal1.equals(animal2));
    }
}
