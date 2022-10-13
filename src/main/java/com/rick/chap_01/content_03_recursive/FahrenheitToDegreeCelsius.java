package com.rick.chap_01.content_03_recursive;

/**
 * @Author: Rick
 * @Date: 2022/9/22 22:35
 */
public class FahrenheitToDegreeCelsius {

    public static void main(String[] args) {
        System.out.println(fahrenheitConverter(90));
        System.out.println(degreeConverter(32));
    }

    public static int fahrenheitConverter(int fahrenheit) {
        return 5 * (fahrenheit - 32) / 9;
    }

    public static int degreeConverter(int degree) {
        return degree * 9 / 5 + 32;
    }
}
