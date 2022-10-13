package com.rick.chap_02_algo_analyisis.content_04_time_complexity;

/**
 * @Author: Rick
 * @Date: 2022/9/23 18:07
 */
public class Fibonacci {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(fib(40));
        long endTime = System.currentTimeMillis();
        System.out.println("Time spent: " + (endTime - startTime) + "\n");


        startTime = System.currentTimeMillis();
        System.out.println(fib_arr(40));
        endTime = System.currentTimeMillis();
        System.out.println("Time spent: " + (endTime - startTime));
    }

    // 这样写，当N=40时候，效率低的惊人
    public static int fib(int n) {
        if (n <= 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static int fib_arr(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <=n ;i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
