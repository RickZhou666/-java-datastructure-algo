package com.rick.chap_01.content_05_generictobuild;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:41
 */
public class BoxingDemo {
    public static void main(String[] args) {
        // auto-boxing & auto-unboxing
        // GenericMemoryCell<Integer> m = new GenericMemoryCell<Integer>(); // diamond syntax
        GenericMemoryCell<Integer> m = new GenericMemoryCell<>(); // diamond syntax, java 7 attributes
        m.write(37);
        int val = m.read();
        System.out.println("Contents are: " + val);
    }
}
