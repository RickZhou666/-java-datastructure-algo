package com.rick.chap_05_hashing.content_02_separatechaining;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Rick
 * @Date: 2022/10/16 16:16
 */
public class T01_SeparateChainingHashTable<AnyType> {

    private static final int DEFAULT_TABLE_SIZE = 101;
    private List<AnyType>[] theLists;

    private int currentSize;

    /**
     * Construct the hash table
     */
    public T01_SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table
     *
     * @param size approximate table size
     */
    public T01_SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
    }

    /**
     * Insert into the hash table. If the item is
     * already present, then do nothing
     *
     * @param x the item to insert
     */
    public void insert(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);

            // Rehash
            if (++currentSize > theLists.length)
                rehash();
        }
    }

    /**
     * Remove from the hash table
     *
     * @param x the item to remove
     */
    public void remove(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    /**
     * Find an item in the hash table
     *
     * @param x the item to search for
     * @return true if x is not found
     */
    public boolean contains(AnyType x) {
        List<AnyType> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    /**
     * Make the hash table logically empty
     */
    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    /**
     * Rehashing for quadratic probing hash table
     */
    private void rehash() {
        List<AnyType>[] oldLists = theLists;
        
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<>();
        }
        
        currentSize =0;
        for (int i = 0; i < oldLists.length; i++) {
            for (AnyType item : oldLists[i])
                insert(item);
        }
    }

    private int myhash(AnyType x) {
        int hashVal = x.hashCode();

        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;

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
