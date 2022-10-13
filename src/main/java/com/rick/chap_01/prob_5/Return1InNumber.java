package com.rick.chap_01.prob_5;

import java.util.EnumSet;

/**
 * @Author: Rick
 * @Date: 2022/9/22 09:03
 */
public class Return1InNumber {
    public static void main(String[] args) {
        // System.out.println("number 2 contains: " +  numOfOne(2) + " 1s, " + "binary form: " + Integer.toBinaryString(2));
        // System.out.println("number 3 contains: " +  numOfOne(3) + " 1s, " + "binary form: " + Integer.toBinaryString(3));
        // System.out.println("number 5 contains: " +  numOfOne(5) + " 1s, " + "binary form: " + Integer.toBinaryString(5));
        System.out.println("number 21 contains: " +  numOfOne(21) + " 1s, " + "binary form: " + Integer.toBinaryString(21));


        System.out.println(numberOfLeadingZeros(21));

    }

    // 如果为奇数，那么1的个数为： num(N / 2) + 1
    // 如果为偶数，那么1的个数为： num(N / 2)
    // 退出条件为：num == 0
    public static int numOfOne(int num) {
        if (num == 0)
            return 0;

        if (num % 2 == 1) {
            return numOfOne(num / 2) + 1;
        } else {
            return numOfOne(num / 2);
        }
    }

    public static int numberOfLeadingZeros(int i) {
        // HD, Figure 5-6
        if (i == 0)
            return 32;
        int n = 1;
        if (i >>> 16 == 0) { n += 16; i <<= 16; } // 如果i向右移动16位，已经是0了。那么向左移动16位，肯定不会超过int最大值的限制。所以至少左边16位都为0
        if (i >>> 24 == 0) { n +=  8; i <<=  8; } // 如果i向右移动24位，已经是0了。那么向左移动8位，肯定不会超过int最大值的限制。所以至少左边8位都为0
        if (i >>> 28 == 0) { n +=  4; i <<=  4; } // 如果i向右移动28位，已经是0了。那么向左移动4位，肯定不会超过int最大值的限制。所以至少左边4位都为0
        if (i >>> 30 == 0) { n +=  2; i <<=  2; } // 如果i向右移动30位，已经是0了。那么向左移动2位，肯定不会超过int最大值的限制。所以至少左边2位都为0
        n -= i >>> 31;
        return n;
    }
}
