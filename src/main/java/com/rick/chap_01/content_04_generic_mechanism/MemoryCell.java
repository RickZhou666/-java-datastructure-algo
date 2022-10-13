package com.rick.chap_01.content_04_generic_mechanism;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:12
 */
public class MemoryCell {
    // MemoryCell class
    // Object read()            -> Returns the stored value
    // void write(Object x)     -> x is stored

    // private internal data representation
    private Object storedValue;


    // public method
    public Object read(){
        return storedValue;
    }

    public void write(Object x){
        storedValue = x;
    }

}
