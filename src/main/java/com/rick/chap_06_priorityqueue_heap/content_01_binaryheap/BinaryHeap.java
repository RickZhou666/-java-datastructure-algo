package com.rick.chap_06_priorityqueue_heap.content_01_binaryheap;

import com.rick.error.UnderFlowException;

/**
 * @Author: Rick
 * @Date: 2022/10/27 23:05
 */
public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize; // Number of elements in heap
    private AnyType[] array; // The heap array

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = (AnyType[]) new Comparable[capacity + 1];
    }

    /**
     * Construct the binary heap given an array of items
     * @param items
     */
    public BinaryHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed
     * @param x
     */
    public void insert(AnyType x) {
        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);

        // percolate up
        int hole = ++currentSize;
        // we start from array[1],
        // so you can always replace array[0] in the beginning
                            // compare with its parent, if smaller, replace it
                            // the worst case is hole = 0, compare to itself then stop loop
                            // anyway this loop will stop
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new UnderFlowException();
        return array[1];
    }

    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw UnderflowException, if empty
     */
    public AnyType deleteMin() {
        if (isEmpty())
            throw new UnderFlowException();

        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
    }


    /**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];
        for (; hole * 2 <= currentSize; hole = child) { // (1) compare with bound (2) replace with the smaller child
            child = hole * 2;

            // 1. find the smallest child
            if (child != currentSize // meaning there is right child
                    && array[child + 1].compareTo(array[child]) < 0) // if right child less than left child, we move to right child index
                child++;

            // 2. compare with parent
            if (array[child].compareTo(tmp) < 0) // if child is less than parent node, switch
                array[hole] = array[child];
            else
                break;
        }
        // put original into correct position
        array[hole] = tmp;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        // from back to front
        for (int i = currentSize / 2; i > 0; i--) {
            percolateDown(i);

        }
    }

    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++) {
            array[i] = old[i];
        }
    }

    public static void main(String[] args) {
        int numItems = 10_000;
        BinaryHeap<Integer> h = new BinaryHeap<>();
        int i = 37;

        for (i = 37; i != 0; i = (i + 37) % numItems)
            h.insert(i);
        for (i = 1; i < numItems; i++) {
            if (h.deleteMin() != i)
                System.out.println("Oops! " + i);
        }
    }
}
