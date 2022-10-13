package com.rick.chap_01.prob_15;

import com.rick.chap_01.content_04_generic_mechanism.Shape;

/**
 * @Author: Rick
 * @Date: 2022/9/23 11:23
 */
public class Rectangle implements Shape {
    int length;
    int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPerimeter() {
        return 2 * getWidth() + 2 * getLength();
    }

    public double getArea() {
        return getWidth() * getLength();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
