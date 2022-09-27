package com.qingwen.basic.day07;

import java.util.Scanner;

//回形数
/*
a[0][0] = 1   a[0][1] = 2   a[0][2] = 3   a[0][3] = 4   a[0][4] = 5
a[1][0] = 16  a[1][1] = 17  a[1][2] = 18  a[1][3] = 19  a[1][4] = 6
a[2][0] = 15  a[2][1] = 24  a[2][2] = 25  a[2][3] = 20  a[2][4] = 7
a[3][0] = 14  a[3][1] = 23  a[3][2] = 22  a[3][3] = 21  a[3][4] = 8
a[4][0] = 13  a[4][1] = 12  a[4][2] = 11  a[4][3] = 10  a[4][4] = 9

第一行： 等于第一角标
第二行：最后一个数
 */
public class ArrayExer02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个数字：");
        int n = sc.nextInt();
        //int n = 7;
        int[][] arr = new int[n][n];

        int count = 0; // 要显示的数据
        int maxX = n - 1; // x轴的最大下标
        int maxY = n - 1; // Y轴的最大下标
        int minX = 0; // x轴的最小下标
        int minY = 0; // Y轴的最小下标
        while (minX <= maxX) {
            for (int x = minX; x <= maxX; x++) {
                arr[minY][x] = ++count;
            }
            minY++;
            for (int y = minY; y <= maxY; y++) {
                arr[y][maxX] = ++count;
            }
            maxX--;
            for (int x = maxX; x >= minX; x--) {
                arr[maxY][x] = ++count;
            }
            maxY--;
            for (int y = maxY; y >= minY; y--) {
                arr[y][minX] = ++count;
            }
            minX++;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                String space = (arr[i][j] + "").length() == 1 ? "0" : "";
                System.out.print(space + arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
