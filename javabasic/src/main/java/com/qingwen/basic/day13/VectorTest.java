package com.qingwen.basic.day13;
import java.util.Scanner;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector vector = new Vector();
        System.out.println("请输入数字：");
        int score = scanner.nextInt();
        while (score >= 0) {
            score = scanner.nextInt();
//            Integer newScore = new Integer(score);
            vector.addElement(score);
        }

        for(int i=0;i<vector.size();i++)
            System.out.println(vector.elementAt(i));

        return;
    }
}
