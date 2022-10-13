package com.rick.chap_01.prob_15;

import com.rick.chap_01.content_04_generic_mechanism.Shape;

import java.util.Comparator;

/**
 * @Author: Rick
 * @Date: 2022/9/23 11:31
 */
public class AreaCompare implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return (int) (o1.getArea() - o2.getArea());
    }
}
