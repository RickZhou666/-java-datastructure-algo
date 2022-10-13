package com.rick.chap_01.content_03_recursive;

/**
 * @Author: Rick
 * @Date: 2022/9/22 22:29
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(11));
    }

    public static int fibonacci(int x) {
        if (x == 0)
            return 1;
        else if (x == 1)
            return 1;
        else if (x == 2) {
            return 2;
        } else {
            return fibonacci(x - 1) + fibonacci(x - 2);
        }
    }
}
