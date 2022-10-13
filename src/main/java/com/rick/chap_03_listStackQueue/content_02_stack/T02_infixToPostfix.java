package com.rick.chap_03_listStackQueue.content_02_stack;

import java.util.Stack;

/**
 * @Author: Rick
 * @Date: 2022/10/13 10:54
 */
public class T02_infixToPostfix {

    public static void main(String[] args) {
        String math = "1+2*3+(4*5+6)*7";
        System.out.println(infixToPostfix(math));

        assert "123*+45*6+7*+".equalsIgnoreCase(infixToPostfix(math));
    }

    // TODO still got some error
    public static String infixToPostfix(String math) {
        Stack<Character> operations = new Stack<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < math.length(); i++) {
            Character c = math.charAt(i);
            if (c == ')') {
                while (!operations.isEmpty() && operations.peek() != '(') {
                    stack.push(operations.pop());
                }
                // pop (
                operations.pop();
            } else if (c == '*') {
                // if it's + or -, we push next digit and *
                if (!operations.isEmpty() && (operations.peek() == '+' || operations.peek() == '-')){
                    Character next = math.charAt(++i);
                    stack.push(next);
                    stack.push(c);
                } else {
                    // else we push *
                    operations.push(c);
                }
            } else if (c == '+'){
                if (!operations.isEmpty() ) {
                    while (!operations.isEmpty() && operations.peek() != '(' && operations.peek() != '+') {
                        stack.push(operations.pop());
                    }
                    stack.push(c);
                } else
                    operations.push(c);
            } else if (c == '('){
                operations.push(c);
            } else {
                stack.push(c);
            }
        }

        while (!operations.isEmpty()){
            stack.push(operations.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            // sb.append(stack.pop());
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
