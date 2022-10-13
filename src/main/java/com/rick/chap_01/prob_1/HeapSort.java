package com.rick.chap_01.prob_1;

/**
 * @Author: Rick
 * @Date: 2022/9/23 09:17
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        // 1. 构建初始大顶堆
        buildMaxHeap(arr);


        // 2. 再排序
        for (int i = arr.length - 1; i >= 0; i--) {
            // （1）先和最末尾交换
            swap(arr, 0, i);
            // （2）最大检查的限制定在 i，并从根结点做maxheapify
            maxHeapify(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    private static void maxHeapify(int[] arr, int i, int size) {
        int left = i * 2 + 1;
        int right = left + 1;
        int largest = i;

        if (left < size && arr[left] > arr[largest])
            largest = left;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);

            // 因为交换后的值可能叶子小，所以要自上向下对maxheap进行调整
            maxHeapify(arr, largest, size);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
