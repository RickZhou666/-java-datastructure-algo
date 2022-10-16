package com.rick.chap_04_tree.content_08_setmap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Rick
 * @Date: 2022/10/16 13:52
 */
public class T01_Set {
    public static void main(String[] args) {

        // Set set = new HashSet();
        T01_Set obj = new T01_Set();
        obj.printSet();

    }

    public void printSet(){
        Set<String> s = new TreeSet<>(new CaseInsensitiveCompare());
        s.add("Hello");
        s.add("HeLLo");
        System.out.println("The size is: " + s.size());
    }


    class CaseInsensitiveCompare implements Comparator<String> {

        @Override
        public int compare(String lhs, String rhs) {
            return lhs.compareToIgnoreCase(rhs);
        }
    }

}
