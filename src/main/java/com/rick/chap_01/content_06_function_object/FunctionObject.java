package com.rick.chap_01.content_06_function_object;

import java.util.Comparator;

/**
 * @Author: Rick
 * @Date: 2022/9/23 00:30
 */
public class FunctionObject {

    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (cmp.compare(arr[i], arr[maxIndex]) > 0)
                maxIndex = i;

        return arr[maxIndex];
    }





}





