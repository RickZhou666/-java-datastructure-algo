package com.rick.chap_04_tree.content_02_binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: Rick
 * @Date: 2022/10/13 14:26
 */
@Data
@AllArgsConstructor
public class T01_BinaryNode {
    Object element;
    T01_BinaryNode left;
    T01_BinaryNode right;

    public T01_BinaryNode(Object element) {
        this.element = element;
    }
}
