package com.rick.chap_01.content_04_generic_mechanism;

import java.util.Optional;

/**
 * @Author: Rick
 * @Date: 2022/9/22 23:30
 */
public class PersonTestDrive {
    public static void main(String[] args) {
        Person[] persons = new Employee[2];
        persons[0] = new Student("Rick", 5);
        persons[1] = new Employee("Eve", 4);


        for (Person p : persons){
            if (p != null)
                System.out.println(p.getClass().getSimpleName());
        }

    }
}
