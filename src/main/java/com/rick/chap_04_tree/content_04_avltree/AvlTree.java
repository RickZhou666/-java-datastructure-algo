package com.rick.chap_04_tree.content_04_avltree;

/**
 * @Author: Rick
 * @Date: 2022/10/15 22:54
 */

/**
 * 1. 输入是AnyType
 * 2. AnyType 继承了Comparable接口，所以里面可以调用compareTo()方法
 * 3. AnyType其超类也适用 <? super AnyType>, AnyType的daddy们
 *
 * @param <AnyType>
 */
public class AvlTree<AnyType extends Comparable<? super AnyType>> {
    private static class AvlNode<AnyType> {
        AnyType element; // the data in the node
        AvlNode<AnyType> left; // left child
        AvlNode<AnyType> right; // right child
        int height; // Height

        // Constructors
        public AvlNode(AnyType theElement) {
            this(theElement, null, null);
        }

        public AvlNode(AnyType element, AvlNode<AnyType> left, AvlNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /**
     * @param t
     * @return Return the height of node t, or -1, if null.
     */
    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }


    /**
     * Internal method to insert into a subtree
     *
     * @param x the item to insert
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private AvlNode<AnyType> insert(AnyType x, AvlNode<AnyType> t) {
        if (t == null)
            return new AvlNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) // x < t.element, go t.left
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ; // Duplicate; do nothing

        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    /**
     * Assume t is either balanced or within one of being balanced
     *
     * @param t
     * @return
     */
    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null)
            return t;

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
            if (height(t.left.left) >= height(t.left.right))    // case 1, left-left
                t = rotateWithLeftChild(t);
            else                                                // case 2, left-right
                t = doubleWithLeftChild(t);
        else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
            if (height(t.right.right) >= height(t.right.left))  // case 3, right-right
                t = rotateWithRightChild(t);
            else                                                // case 4, right-left
                t = doubleWithRightChild(t);

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }


    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1
     * Update heights, then return new root
     *
     * @param k2
     * @return
     */
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Double ratate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     * Update heights, then return new root
     *
     * @param k3
     * @return
     */
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }


    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> k2) {
        AvlNode<AnyType> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(k2.height, height(k1.right)) + 1;
        return k1;
    }

    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    /**
     * Internal method to remove from a subtree
     *
     * @param x the item to remove
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private AvlNode<AnyType> remove(AnyType x, AvlNode<AnyType> t) {
        if (t == null)
            return t; // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) { // two children
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else // one of is null
            t = (t.left != null) ? t.left : t.right;

        // after deletion, do balance
        return balance(t);
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree
     * @return node containing the smallest item
     */
    private AvlNode<AnyType> findMin(AvlNode<AnyType> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }
}
