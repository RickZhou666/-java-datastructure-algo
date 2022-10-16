package com.rick.chap_05_hashing.content_02_separatechaining;

/**
 * @Author: Rick
 * @Date: 2022/10/16 16:20
 */
public class Employee {
    private String name;
    private double salary;
    private int seniority;


    public boolean equals(Object rhs){
        return rhs instanceof Employee && name.equals(((Employee)rhs).name);
    }

    public int hashCode(){
        return name.hashCode();
    }

    // additional fields and methods
}
