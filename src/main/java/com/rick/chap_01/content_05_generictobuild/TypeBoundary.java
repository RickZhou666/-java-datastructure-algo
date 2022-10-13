package com.rick.chap_01.content_05_generictobuild;

/**
 * @Author: Rick
 * @Date: 2022/9/23 00:02
 */
public class TypeBoundary {

    // public static <AnyType> AnyType findMax(AnyType[] arr) {
    // public static <AnyType extends Comparable> AnyType findMax(AnyType[] arr) { // 1. 解决办法，使用类型界限(type bound)
    // public static <AnyType extends Comparable<AnyType>> AnyType findMax(AnyType[] arr) { // 2. 解决办法，因为Comparable是泛型接口，所以最好对其也加上类型限制Comparable<AnyType>
    public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] arr) {
        // 3. 解决办法，(1) Shape 实现(implements) Comparable<Shape>
        // (2) Square 继承(extends) Shape
        // (3) 此时，Square 实现 Comparable<Shape>
        // (4) 于是，Square IS-A Comparable<Shape>
        // (5) 但 Square IS-NOT-A Comparable<Square>
        // 所以说 AnyType IS-A Comparable<T>，其实T是AnyType的父类。由于我们不需要知道准确的类型T，因此可使用通配符
        // public static <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] arr)


        // 编译器接受类型 T 的数组
        // T 实现 Comparable<S>接口
        // T IS-A S
        int maxIndex = 0;

        for (int i = 1; i < arr.length; i++)
            if (arr[i].compareTo(arr[maxIndex]) > 0) // 因为AnyType并不是(IS-A) Comparable，所以报错
                maxIndex = i;

        return arr[maxIndex];
    }
}
