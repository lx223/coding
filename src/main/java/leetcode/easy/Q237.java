package leetcode.easy;

import leetcode.CommonClasses;

/**
 * This class contains solution to <a href = "https://leetcode.com/problems/delete-node-in-a-linked-list/">LeetCode
 * Q237</>
 *
 * Thinking process:
 *
 * This is a simple question. Since head is not given, all you can do is changing the value (this actually contradicts
 * the spirit of data encapsulation).
 */
public class Q237 extends CommonClasses {
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
