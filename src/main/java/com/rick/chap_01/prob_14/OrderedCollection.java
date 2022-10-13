package com.rick.chap_01.prob_14;

/**
 * @Author: Rick
 * @Date: 2022/9/23 11:06
 */
public class OrderedCollection<AnyType> {

    AnyType[] arr;
    static int defaultSize = 10;
    static int position = 0;

    public OrderedCollection(AnyType[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return position;
    }

    public boolean isEmpty() {
        return position == 0;
    }

    public void makeEmpty() {
        for (int i = 0; i < position; i++) {
            arr[i] = null;
        }
        position = 0;
    }

    public boolean insert(AnyType obj) {
        if (position == defaultSize) {
            return false;
        }
        arr[position] = obj;
        position++;
        return true;
    }

    public boolean isPresent(AnyType obj) {
        for (int i = 0; i < position; i++) {
            if (arr[i].equals(obj))
                return true;
        }
        return false;
    }

    public <AnyType extends Comparable<? super AnyType>> AnyType findMiN(AnyType[] arr) {
        int minIdx = 0;
        for (int i = 1; i < position; i++) {
            if (arr[i].compareTo(arr[minIdx]) < 0)
                minIdx = i;
        }
        return arr[minIdx];
    }

    public <AnyType extends Comparable<? super AnyType>> AnyType findMax(AnyType[] arr) {
        int maxIdx = 0;
        for (int i = 1; i < position; i++) {
            if (arr[i].compareTo(arr[maxIdx]) < 0)
                maxIdx = i;
        }
        return arr[maxIdx];
    }


}
