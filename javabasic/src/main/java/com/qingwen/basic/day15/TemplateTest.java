package com.qingwen.basic.day15;

public class TemplateTest {
    public static void main(String[] args) {
        Template subTemplate = new SubTemplate();
        subTemplate.spendTime();
    }
}


abstract class Template{
    public void spendTime(){
        Long start = System.currentTimeMillis();
        this.code();
        Long end = System.currentTimeMillis();

        System.out.println("花费的时间是:" + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends Template{
    @Override
    public void code() {
        for(int i=0;i<10000;i++)
            System.out.println("输出:"+i);
    }
}