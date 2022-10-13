package com.rick.chap_02_algo_analyisis.content_01_math;

/**
 * @Author: Rick
 * @Date: 2022/9/23 15:51
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        int a = 3, b = 6;
        System.out.println(gcd(a, b));
    }

    public static int gcd(int a, int b){
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
