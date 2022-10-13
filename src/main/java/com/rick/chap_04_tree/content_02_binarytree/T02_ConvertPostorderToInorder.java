package com.rick.chap_04_tree.content_02_binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: Rick
 * @Date: 2022/10/13 14:48
 */
public class T02_ConvertPostorderToInorder {
    public static void main(String[] args) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer('1');
        queue.offer('2');
        queue.offer('+');
        queue.offer('3');
        queue.offer('4');
        queue.offer('5');
        queue.offer('+');
        queue.offer('*');
        queue.offer('*');

        System.out.println("\n" + convert(queue));


    }

    public static boolean convert(Queue<Character> queue) {
        Stack<T01_BinaryNode> stack = new Stack<>();

        while (!queue.isEmpty()) {
            Character cur = queue.poll();
            if (!Character.isDigit(cur)) {
                T01_BinaryNode right = stack.pop();
                T01_BinaryNode left = stack.pop();

                T01_BinaryNode curRoot = new T01_BinaryNode(cur, left, right);
                stack.push(curRoot);
            } else {
                T01_BinaryNode leafNode = new T01_BinaryNode(cur);
                stack.push(leafNode);
            }
        }

        printInOrder(stack.peek());

        return stack.size() == 1;

    }

    private static void printInOrder(T01_BinaryNode root) {
        if (root == null)
            return;
        System.out.print("(");
        printInOrder(root.left);
        System.out.print((Character) root.element);
        printInOrder(root.right);
        System.out.print(")");
    }

}
