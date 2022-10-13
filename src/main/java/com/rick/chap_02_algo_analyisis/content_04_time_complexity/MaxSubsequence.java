package com.rick.chap_02_algo_analyisis.content_04_time_complexity;

/**
 * @Author: Rick
 * @Date: 2022/9/23 18:25
 */
public class MaxSubsequence {


    public static int algo_01(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int curSum = 0;
                for (int k = i; k <= j; k++)
                    curSum += arr[k];


                if (curSum > maxSum)
                    maxSum = curSum;
            }
        }
        return maxSum;
    }

    public static int algo_02(int[] arr) {
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int curSum = 0;

            for (int j = i; j < arr.length; j++) {
                curSum += arr[j];
                if (curSum > maxSum)
                    maxSum = curSum;
            }
        }
        return maxSum;
    }
}
