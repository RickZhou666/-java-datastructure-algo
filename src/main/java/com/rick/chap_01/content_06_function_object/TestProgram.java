package com.rick.chap_01.content_06_function_object;

import static com.rick.chap_01.content_06_function_object.FunctionObject.findMax;

/**
 * @Author: Rick
 * @Date: 2022/9/23 00:36
 */
public class TestProgram {
    public static void main(String[] args) {
        String[] arr = {"ZEBRA", "alligator", "crocodile"};
        System.out.println(findMax(arr, new CaseInsensitiveCompare()));
    }
}
