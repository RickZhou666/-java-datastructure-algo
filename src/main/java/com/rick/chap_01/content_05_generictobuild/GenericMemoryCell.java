package com.rick.chap_01.content_05_generictobuild;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:36
 */
public class GenericMemoryCell<AnyType> {
    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType x) {
        storedValue = x;
    }
}
