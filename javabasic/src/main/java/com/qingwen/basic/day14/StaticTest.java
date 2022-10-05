package com.qingwen.basic.day14;

public class StaticTest {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        c1.setName("姚明");
        c1.setAge(40);

        Chinese c2 = new Chinese();
        c2.setName("马龙");
        c2.setAge(30);

        System.out.println(c1);
        System.out.println(c2);
    }
}

class Chinese{
    static String nation = "China";
    private String name;
    private int age;

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

    @Override
    public String toString() {
        return "Chinese{" +
                "nation='" + nation + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

