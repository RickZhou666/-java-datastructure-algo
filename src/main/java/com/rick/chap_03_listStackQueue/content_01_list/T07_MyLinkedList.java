package com.rick.chap_03_listStackQueue.content_01_list;

import java.nio.file.ClosedWatchServiceException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: Rick
 * @Date: 2022/10/12 11:57
 */
public class T07_MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    // T07_MyLinkedList 被修改的次数, add, remove
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    // 嵌套类
    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        // this will connect prev and next node for newNode
        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            this.data = d;
            this.prev = p;
            this.next = n;
        }
    }

    public T07_MyLinkedList() {
        doClear();
    }

    private void doClear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }
    public int size() {
        return theSize;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }
    public void add(int idx, AnyType x) {
        addBefore(getNode(idx, 0, size()), x);
    }



    public AnyType get(int idx) {
        return getNode(idx).data;
    }
    public AnyType set(int idx, AnyType newVal) {
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int idx) {
        return remove(getNode(idx));
    }


    /**
     * Adds an item to this collection, at specified position p,
     * Items at or after that position are slid one position higher.
     * @param p Node to add before
     * @param x any object.
     * @throws IndexOutOfBoundsException if idx is not between 0 and size().
     */
    private void addBefore(Node<AnyType> p, AnyType x) {
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;

        // 2. meld in two lines
        // Node<AnyType> newNode = new Node<>(x, p.prev, p);
        // p.prev = p.prev.next = newNode;

        // 3. meld in one line
        // p.prev = p.prev.next = new Node<>(x, p.prev, p);

        theSize++;
        modCount++;
    }
    /**
     * Removes the object contained in Node p.
     * @param p the Node containing the ojbect
     * @return the item was removed from the collection
     */
    private AnyType remove(Node<AnyType> p) {
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }
    /**
     * Gets the Node at position idx, which must range from 0 to size() - 1.
     *
     * @param idx index to search at.
     * @return internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not
     *                                   between 0 and size() - 1, inclusive.
     */
    private Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    /**
     * Gets the Node at position idx, which must range from lower to upper
     *
     * @param idx   index to search at.
     * @param lower lowest valid index.
     * @param upper highest valid index.
     * @return internal node corresponding to idx
     * @throws IndexOutOfBoundsException if idx is not
     *                                   between lower and upper, inclusive
     */
    private Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;

        if (idx < lower || idx > upper)
            throw new IndexOutOfBoundsException();

        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }


    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType> {
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;


        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if(!hasNext())
                throw new NoSuchElementException();

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();

            T07_MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }
}
