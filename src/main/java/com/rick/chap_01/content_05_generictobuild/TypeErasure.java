package com.rick.chap_01.content_05_generictobuild;

/**
 * @Author: Rick
 * @Date: 2022/9/23 00:16
 */
public class TypeErasure {
    public static void main(String[] args) {
        GenericMemoryCell<Integer> cell1 = new GenericMemoryCell<>();
        cell1.write(4);
        System.out.println("Contents are: " + cell1.read() + "\n");

        Object cell = cell1;
        GenericMemoryCell<String> cell2 = (GenericMemoryCell<String>) cell;
        String s = cell2.read();
        System.out.println("Contents are: " + s);
    }
}
