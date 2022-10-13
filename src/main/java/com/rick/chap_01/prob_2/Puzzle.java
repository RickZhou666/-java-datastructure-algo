package com.rick.chap_01.prob_2;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Rick
 * @Date: 2022/9/23 09:54
 */
public class Puzzle {
    public static void main(String[] args) {


    }


    Set<String> dictionary = new HashSet<>();
    Set<String> foundWords = new HashSet<>();

    public void solvePuzzle(char[][] words) {

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[0].length; j++) {
                dfs(words, i, j, new boolean[words.length][words[0].length], new StringBuilder());
            }
        }
    }

    private void dfs(char[][] words, int i, int j, boolean[][] boo, StringBuilder sb) {
        if (i < 0 || i >= words.length || j < 0 || j >= words[0].length || boo[i][j]) {
            return;
        }

        boo[i][j] = true;
        sb.append(words[i][j]);

        if (dictionary.contains(sb.toString()) && foundWords.add(sb.toString())) {
            print(sb.toString());
        }

        dfs(words, i + 1, j, boo, sb);
        dfs(words, i - 1, j, boo, sb);
        dfs(words, i, j + 1, boo, sb);
        dfs(words, i, j - 1, boo, sb);

        sb.deleteCharAt(sb.length() - 1);
        boo[i][j] = false;
    }

    private void print(String word) {
        System.out.println(word);
    }
}
