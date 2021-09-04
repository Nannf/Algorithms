package com.nannf.exam.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Nannf
 * @version v1.0
 * @Description 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
 * 你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。
 * @date 2021/9/4 15:46
 */
public class Solution_225 {
    // 这个比栈模拟队列麻烦一点
    class MyStack {
        Queue<Integer> left;
        Queue<Integer> right;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            right.add(x);
            while (!left.isEmpty()) {
                right.add(left.poll());
            }
            left = right;
            Queue<Integer> temp = new ArrayDeque<>();
            right = temp;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return  left.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
           return left.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return left.isEmpty();
        }
    }
}
