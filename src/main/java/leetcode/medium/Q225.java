package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/implement-stack-using-queues/">LeetCode
 * Q225</>
 *
 * Thinking process:
 *
 * Since only queues are allowed, either push or pop/top is slow. In this case, push has linear time complexity whereas
 * pop/top has constant time complexity.
 */
public class Q225 {

    Queue<Integer> queue = new ArrayDeque<>();

    public void push(int x) {
        queue.offer(x);
        for (int count = queue.size() - 1; count > 0; count--) {
            queue.offer(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
