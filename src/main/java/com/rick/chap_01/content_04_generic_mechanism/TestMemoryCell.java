package com.rick.chap_01.content_04_generic_mechanism;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:14
 */
public class TestMemoryCell {
    public static void main(String[] args) {
        MemoryCell m = new MemoryCell();

        m.write("37");
        String val = (String) m.read();
        System.out.println("Contents are: " + val);

    }
}
