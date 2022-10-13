package com.rick.chap_01.prob_10;

/**
 * @Author: Rick
 * @Date: 2022/9/23 10:32
 */
public class ModCalculation {

    public static void main(String[] args) {

        int n = 100;
        for (int i = 1; i <= n; i++){
            mod2(i);
        }
    }

    public static void mod2(int n) {
        // System.out.println(Math.pow(2, n));
        System.out.print((Math.pow(2, n) % 5) + "\t");
        if (n % 12 == 0)
            System.out.println();

    }
}
