package com.rick.chap_02_algo_analyisis.content_04_time_complexity;

/**
 * @Author: Rick
 * @Date: 2022/9/23 17:54
 */
public class Summation {
    public static void main(String[] args) {

        System.out.println(sum(4));
    }
    public static int sum(int n){
        int partialSum;
        partialSum = 0;
        for (int i = 1; i <= n; i++) {
            partialSum += i * i * i;
        }
        return partialSum;
    }
}
