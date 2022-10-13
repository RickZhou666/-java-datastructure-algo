package com.rick.chap_01.prob_15;

import com.rick.chap_01.content_04_generic_mechanism.Shape;
import com.sun.javafx.geom.ShapePair;

import java.util.Collection;
import java.util.Comparator;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:45
 */
public class Area {

    public static void main(String[] args) {
        Rectangle rec01 = new Rectangle(2, 10);
        Rectangle rec02 = new Rectangle(5, 5);
        Rectangle rec03 = new Rectangle(4, 7);
        Rectangle rec04 = new Rectangle(3, 9);

        Shape[] shapes = {rec01, rec02, rec03, rec04};

        System.out.println(findMax(shapes, new AreaCompare()));
        System.out.println(findMin(shapes, new AreaCompare()) + "\n");


        System.out.println(findMax(shapes, new PerimeterCompare()));
        System.out.println(findMin(shapes, new PerimeterCompare()));
    }


    public static <AnyType> AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (cmp.compare(arr[i], arr[maxIndex]) > 0)
                maxIndex = i;

        return arr[maxIndex];
    }

    public static <AnyType> AnyType findMin(AnyType[] arr, Comparator<? super AnyType> cmp) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++)
            if (cmp.compare(arr[i], arr[minIndex]) < 0)
                minIndex = i;

        return arr[minIndex];
    }


    public static double totalArea(Shape[] arr) {
        double total = 0;

        for (Shape s : arr) {
            if (s != null)
                total += s.getArea();
        }

        return total;
    }

    // public static double totalArea(Collection<Shape> arr){
    //     double total = 0;
    //
    //     for (Shape s : arr){
    //         if (s != null)
    //             total += s.getArea();
    //     }
    //     return total;
    // }


    // wildcard to match its super class
    // Circle IS-A Shape
    // Rectangle IS-A Shape
    // Square IS-A Shape

    // <? extends Shape>    表示Shape的子类, 向下
    // <? super Shape>      表示Shape的超类, 向上
    public static double totalArea(Collection<? extends Shape> arr) {
        double total = 0;

        for (Shape s : arr) {
            if (s != null)
                total += s.getArea();
        }
        return total;
    }


    // 泛型static方法
    public static <AnyType> boolean contains(AnyType[] arr, AnyType x) {
        for (AnyType val : arr) {
            if (x.equals(val))
                return true;
        }
        return false;
    }
}
