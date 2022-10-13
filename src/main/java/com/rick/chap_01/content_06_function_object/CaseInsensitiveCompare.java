package com.rick.chap_01.content_06_function_object;

import java.util.Comparator;

/**
 * @Author: Rick
 * @Date: 2022/9/23 00:38
 */
public class CaseInsensitiveCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }
}
