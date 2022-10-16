package com.rick.chap_05_hashing.content_03_quadraticprobing;

/**
 * @Author: Rick
 * @Date: 2022/10/16 21:26
 */
public class QuadraticProbingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 11;
    private HashEntry<AnyType>[] array;
    private int currentSize;

    /**
     * Construct the hash table
     */
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table
     *
     * @param size the approximate initial size.
     */
    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    /**
     * Find an item in the hash table
     *
     * @param x the item to search for
     * @return the matching item.
     */
    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }


    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        // Insert x as active
        int currentPos = findPos(x);
        if (isActive(currentPos))
            return;

        array[currentPos] = new HashEntry<>(x, true);

        // rehash
        if (currentSize > array.length / 2)
            rehash();
    }

    /**
     * Remove from the hash table
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            array[currentPos].isActive = false;
    }

    private static class HashEntry<AnyType> {
        public AnyType element; // the element
        public boolean isActive; // false if marked deleted

        public HashEntry(AnyType element) {
            this.element = element;
        }

        public HashEntry(AnyType element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }
    }

    /**
     * Internal method to allocate array.
     *
     * @param arraySize the size of array
     */
    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    /**
     * Return true if currentPos exists and is active
     *
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active
     */
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    /**
     * Method that performs quadratic probing resolution in half-empty table.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myhash(x);

        while (array[currentPos] != null &&
                !array[currentPos].element.equals(x)) {
            currentPos += offset; // Compute ith prob
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    private void rehash() {
        HashEntry<AnyType>[] oldArray = array;

        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;

        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
        }
    }

    private int myhash(AnyType x) {
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;

        return hashVal;
    }

    /**
     * Internal method to find a prime number at least as large as n.
     *
     * @param n the starting number (must be positive)
     * @return a prime number larger than or equal to n.
     */
    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        for (; !isPrime(n); n += 2)
            ;
        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm
     *
     * @param n the number to test
     * @return the result of the test
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0) // make sure it's an odd number
            return false;
        for (int i = 3; i * i <= n; i += 2) { // check with each odd number
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
