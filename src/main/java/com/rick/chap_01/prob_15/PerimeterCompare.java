package com.rick.chap_01.prob_15;

import com.rick.chap_01.content_04_generic_mechanism.Shape;

import java.util.Comparator;

/**
 * @Author: Rick
 * @Date: 2022/9/23 11:32
 */
public class PerimeterCompare implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getPerimeter() - o2.getPerimeter();
    }
}
