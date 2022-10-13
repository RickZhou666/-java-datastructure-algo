package com.rick.chap_01.prob_6;

/**
 * @Author: Rick
 * @Date: 2022/9/22 09:40
 */
public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation obj = new StringPermutation();
        obj.permute("abc");
    }

    public void permute(String str) {
        permute(str.toCharArray(), 0, str.length(), new StringBuilder(), new boolean[str.length()]);
    }

    public void permute(char[] str, int low, int high, StringBuilder sb, boolean[] boo) {
        if (sb.length() == str.length) {
            System.out.println(sb.toString());
            return;
        }
        for (int i = low; i < high; i++) {
            if (!boo[i]) {
                boo[i] = true;
                sb.append(str[i]);
                permute(str, low, high, sb, boo);
                sb.deleteCharAt(sb.length() - 1);
                boo[i] = false;
            }
        }


    }
}
