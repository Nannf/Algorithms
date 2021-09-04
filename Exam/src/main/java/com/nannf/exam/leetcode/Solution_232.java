package com.nannf.exam.leetcode;

import java.util.Stack;

/**
 * @author Nannf
 * @version v1.0
 * @Description
 * @date 2021/9/4 15:07
 * <p>
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * 你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * <p>
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class Solution_232 {
    class MyQueue {
        Stack<Integer> leftStack;
        Stack<Integer> rightStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            leftStack = new Stack<>();
            rightStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            leftStack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            int ans = rightStack.pop();
            while(!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
            return ans;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
            int ans = rightStack.peek();
            while(!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
            return ans;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return leftStack.isEmpty();
        }
    }
}
