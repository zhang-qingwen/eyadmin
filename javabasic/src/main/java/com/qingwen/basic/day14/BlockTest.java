package com.qingwen.basic.day14;

public class BlockTest {
    public static void main(String[] args) {
        String desc = Boy.desc;
//        System.out.println(desc);
        
        Person person = new Person("zhangsan",10);
        System.out.println("*************************************");
        Man man = new Man("zhangsan",10);
        System.out.println("*************************************");
        Boy boy =new Boy("zhangsan",10);
    }
}

class Person{
    private String name;
    private int age;
    static String desc = "我是一个人";

    public Person(){

    }

    public Person(String name, int age) {
        System.out.println("constructor of Person");
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", desc='" + desc + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("吃饭 .....");
    }

    //静态代码块
    static {
        System.out.println("hello, static block of Person!!");
    }

    //非静态代码块
    {
        System.out.println("hello, block of Person!!");
    }
}

class Man extends Person{
    static {
        System.out.println("hello, static block of Man!!");
    }
    {
        System.out.println("hello, block of Man!!");
    }

    public Man(){

    }

    public Man(String name, int age) {
        super(name, age);
        System.out.println("constructor of Man");
        this.setName(name);
        this.setAge(age);
    }
}

class Boy extends Man{
    static {
        System.out.println("hello, static block of Boy!!");
    }
    {
        System.out.println("hello, block of Boy!!");
    }
    public Boy(){

    }

    public Boy(String name, int age) {
        super(name, age);
        System.out.println("constructor of Boy");
        this.setName(name);
        this.setAge(age);
    }
}