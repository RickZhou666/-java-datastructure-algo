package com.rick.chap_01.content_01_intro;

import java.util.Arrays;

/**
 * @Author: Rick
 * @Date: 2022/9/22 10:26
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {// each time choose the smallest number from {j ~ len} to position [i]
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
