package com.rick.chap_03_listStackQueue.content_01_list;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: Rick
 * @Date: 2022/10/12 09:56
 */
public class T05_removeMethod {
    // ArrayList: 二次的，remove的效率不高O(N)。如果插入idx-0, 整个list将向后移。除非插入最后一个位置
    // LinkedList: 二次的，get的效率不高，而且对remove同样地低效
    public static void removeEvensVer1(List<Integer> lst) {
        int i = 0;
        while (i < lst.size()) {
            if (lst.get(i) % 2 == 0) {
                lst.remove(i);
            } else
                i++;
        }
    }


    // 迭代器遍历是高效的。但Collection.remove() 必须再次搜索，它花费线性时间
    // 而且会抛出 ConcurrentModifiedException
    public static void removeEvensVer2(List<Integer> lst) {
        for (Integer x : lst) {
            if (x % 2 == 0) {
                lst.remove(x);
            }
        }
    }


    // ArrayList: remove方法仍然昂贵，数组的项必须要移动。二次时间
    // LinkedList: 常数时间，迭代器位于被删除节点的附近。整个程序线性时间
    public static void removeEvensVer3(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0)
                itr.remove();
        }
    }


}





