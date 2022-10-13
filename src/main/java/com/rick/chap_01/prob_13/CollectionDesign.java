package com.rick.chap_01.prob_13;

import java.util.Arrays;

/**
 * @Author: Rick
 * @Date: 2022/9/23 11:00
 */
public class CollectionDesign<AnyType> {
    Object[] objects;
    int defaultSize = 10;
    int position = 0;

    public CollectionDesign() {
        this.objects = new Object[defaultSize];
    }

    public int getSize() {
        return position;
    }

    public boolean isEmpty() {
        return position == 0;
    }

    public void makeEmpty() {
        for (int i = 0; i < position; i++) {
            objects[i] = null;
        }
        position = 0;
    }

    public boolean insert(AnyType obj) {
        if (position == defaultSize) {
            return false;
        }
        objects[position] = obj;
        position++;
        return true;
    }

    public boolean isPresent(AnyType obj) {
        for (int i = 0; i < position; i++) {
            if (objects[i].equals(obj))
                return true;
        }
        return false;
    }


}
