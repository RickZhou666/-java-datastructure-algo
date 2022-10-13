package com.rick.chap_03_listStackQueue.content_02_stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Rick
 * @Date: 2022/10/13 09:35
 */
// https://www.slf4j.org/codes.html#noProviders
@Slf4j
public class T01_ParenthesisChecker {

    public static void main(String[] args) {
        String str = "{}[]()(";
        System.out.println(parenthesisChecker(str));
    }

    public static boolean parenthesisChecker(String str) {
        List<Character> stack = new ArrayList<>();

        for (Character c : str.toCharArray()) {
            if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty()) {
                    char top = stack.get(stack.size() - 1);
                    if ((c == ')' && top != '(')
                            || (c == ']' && top != '[')
                            || (c == '}' && top != '{')) {
                        return false;
                    }
                    // pop
                    stack.remove(stack.size() - 1);
                } else{
                    log.info("stack is empty, but there still some parenthesis");
                    return false;
                }

            } else {
                // push
                stack.add(c);
            }
        }
        // must be empty if it's valid
        return stack.isEmpty();
    }
}
