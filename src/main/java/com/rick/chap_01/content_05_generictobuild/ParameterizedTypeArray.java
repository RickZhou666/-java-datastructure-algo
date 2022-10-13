package com.rick.chap_01.content_05_generictobuild;

/**
 * @Author: Rick
 * @Date: 2022/9/23 00:23
 */
public class ParameterizedTypeArray {
    public static void main(String[] args) {
        GenericMemoryCell<String>[] arr1 = new GenericMemoryCell[10];
        GenericMemoryCell<Double> cell = new GenericMemoryCell<>();
        cell.write(4.5);
        Object[] arr2 = arr1;
        arr2[0] = cell;
        String s = arr1[0].read();
    }
}
