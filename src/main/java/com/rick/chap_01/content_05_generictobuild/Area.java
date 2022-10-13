package com.rick.chap_01.content_05_generictobuild;

import com.rick.chap_01.content_04_generic_mechanism.Shape;
import org.omg.CORBA.Any;

import java.util.Collection;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:45
 */
public class Area {
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
