package com.rick.chap_04_tree.content_03_binarysearchtree;

import com.rick.error.UnderFlowException;

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

    public AnyType findMin() throws UnderFlowException {
        if (isEmpty())
            throw new UnderFlowException();
        return findMin(root).element;
    }

    public AnyType findMax() throws UnderFlowException {
        if (isEmpty())
            throw new UnderFlowException();
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = insert(x, root);
    }


    public void printTree(AnyType x) {
        root = insert(x, root);
    }


    /**
     * Internal method to find an item in a subtree
     *
     * @param x is item to search for
     * @param t th enode that roots the subtree
     * @return true if the item is found; false otherwise
     */
    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
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
     *
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
     *
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

    /**
     * Internal method to insert into a subtree
     *
     * @param x the item to insert
     * @param t the node that roots the subtree.
     * @return the new root of the subtree
     */

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ; // duplicate; do nothing

        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;

        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) { // Two children
            t.element = findMin(t.right).element; // replace with right child's min value
            t.right = remove(t.element, t.right); // try to delete right child's min value
        } else
            t = (t.left != null) ? t.left : t.right;

        return t;
    }

    private void printTree(BinaryNode<AnyType> t) {

    }
}
