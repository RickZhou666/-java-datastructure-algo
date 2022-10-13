package com.rick.chap_01.prob_3;

/**
 * @Author: Rick
 * @Date: 2022/9/23 10:05
 */
public class PrintDoubleType {

    public static void main(String[] args) {
        double val = 5.135;
        printDouble(val);
    }

    static void printDouble(double val) {
        // make it string
        String valString = String.valueOf(val);

        for (char c : valString.toCharArray()){
            System.out.println(c);
        }

    }

    // private static void printDigit(double v) {
    //     System.out.println(v);
    // }


}
