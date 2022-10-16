package com.rick.chap_05_hashing.content_01_hashfunction;

/**
 * @Author: Rick
 * @Date: 2022/10/16 16:04
 */
public class T01_HashFunction {
    public static int hash1(String key, int tableSize) {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++)
            hashVal += key.charAt(i);

        return hashVal % tableSize;
    }


    public static int hash2(String key, int tableSize) {
        return (key.charAt(0)
                + 27 * key.charAt(1)
                + 729 * key.charAt(2)) % tableSize;
    }

    public static int hash3(String key, int tableSize) {
        int hashVal = 0;
        /*
        *   (1) 37 * 0 + key[0]
        *   (2) key[0] * 37 + key[1]
        *   (3) (key[0] * 37 + key[1]) * 37 + key[2]
        *   (4) ((key[0] * 37 + key[1]) * 37 + key[2]) * 37 + key[3]
        */
        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }


        hashVal %= tableSize;

        if (hashVal < 0)
            hashVal += tableSize;

        return hashVal;
    }


}
