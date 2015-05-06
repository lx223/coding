package leetcode.easy;

import leetcode.CommonClasses;

/**
 * Created by lanxiao on 06/05/15.
 */
public class Q206 extends CommonClasses {
    /*
    LeetCode Q206:
        Reverse a singly linked list
    Thinking:
        It is often useful to use a fakeHead such as 1 in the following case to simplify coding
        Before reversing: 1 -> 2 -> 3 -> 4
        1st op: 1 -> 3 -> 2 -> 4
        2nd op: 1 -> 4 -> 3 -> 2
        2 -> 3 -> 4 is now reversed
     */
    public ListNode reverseList(ListNode head) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            head.next.next = fakeHead.next;
            fakeHead.next = head.next;
            head.next = next;
        }
        return fakeHead.next;
    }

}
