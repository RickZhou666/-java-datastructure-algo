package com.rick.chap_03_listStackQueue.content_01_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: Rick
 * @Date: 2022/10/12 09:09
 */
public class T03_ConcurrentModifiedException {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(Integer.valueOf(1));
        collection.add(Integer.valueOf(2));
        collection.add(Integer.valueOf(3));
        collection.add(Integer.valueOf(4));
        collection.add(Integer.valueOf(5));
        collection.add(Integer.valueOf(6));

        Iterator iterator = collection.iterator();
        // java.util.ConcurrentModificationException
        // while (iterator.hasNext()){
        //     Object next = iterator.next();
        //     collection.remove(Integer.valueOf(5));
        //     System.out.println(next);
        // }


        // if invoke iterator.remove(), thi is legitimate
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }

        System.out.println("size is: " + collection.size());

    }
}
