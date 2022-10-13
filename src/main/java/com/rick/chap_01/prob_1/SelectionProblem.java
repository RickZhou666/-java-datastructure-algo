package com.rick.chap_01.prob_1;

import com.rick.chap_01.content_01_intro.BubbleSort;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * @Author: Rick
 * @Date: 2022/9/23 08:32
 */
public class SelectionProblem {
    public static void main(String[] args) {
        int[] arr = createArray(100_000);
        int[] arr1 = Arrays.copyOf(arr, arr.length);
        int[] arr2 = Arrays.copyOf(arr, arr.length);

        // 1. Bubble sort execution time
        long startTime = System.currentTimeMillis();
        selectBubbleSort(arr1);
        long endTime = System.currentTimeMillis();
        System.out.println("time spent: " + (endTime - startTime) + "\n");

        // 2. heapsort execution time
        startTime = System.currentTimeMillis();
        selectHeapSort(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("time spent: " + (endTime - startTime));


    }


    private static Random randomGenerator = new Random(System.currentTimeMillis());

    public static int[] createArray(int n) {
        int[] arr = new int[n / 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomGenerator.nextInt(1000);
        }
        return arr;
    }

    public static void selectBubbleSort(int[] arr) {
        BubbleSort.bubbleSort(arr);
    }

    public static void selectHeapSort(int[] arr) {
        HeapSort.heapSort(arr);
    }


}
