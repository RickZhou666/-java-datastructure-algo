package com.rick.chap_04_tree.content_03_binarysearchtree;

import java.nio.BufferUnderflowException;

/**
 * @Author: Rick
 * @Date: 2022/10/13 15:29
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {
    private static class BinaryNode<AnyType> {
        AnyType element;            // the data in the node
        BinaryNode<AnyType> left;   // left child
        BinaryNode<AnyType> right;  // right child

        // Constructors
        public BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        public BinaryNode(AnyType theElement, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = theElement;
            this.left = left;
            this.right = right;
        }
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(AnyType X) {
        root = insert(x, root);
    }

    public void remove(AnyType X) {
        root = insert(x, root);
    }


    public void printTree(AnyType X) {
        root = insert(x, root);
    }


    /**
     * Internal method to find an item in a subtree
     * @param x is item to search for
     * @param t th enode that roots the subtree
     * @return true if the item is found; false otherwise
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null){
            return false;
        }

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else
            return true; // Match
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree
     * @return node containing the smallest item
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null) {
            while (t.right != null)
                t = t.right;
        }
        return t;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {

    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {

    }

    private void printTree(BinaryNode<AnyType> t) {

    }
}
