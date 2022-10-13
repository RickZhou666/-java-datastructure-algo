package com.rick.chap_01.content_03_recursive;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:00
 */
public class PrintOut {
    public static void main(String[] args) {
        printOut(123);
    }

    // 1. traverse to the highest digit
    // 2. then print each digit recursively
    public static void printOut(int n){
        if (n >= 10){
            printOut(n / 10);
        }
        printDigit(n % 10);
    }

    private static void printDigit(int i) {
        System.out.println(i);
    }
}
