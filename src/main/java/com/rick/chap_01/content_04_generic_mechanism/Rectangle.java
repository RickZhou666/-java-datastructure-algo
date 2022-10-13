package com.rick.chap_01.content_04_generic_mechanism;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:24
 */
public class Rectangle implements Shape {

    private double area;



    public Rectangle(double v) {
        this.area = v;
    }

    public Rectangle(double v, double v1) {
        this.area = v * v1;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int getPerimeter() {
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
