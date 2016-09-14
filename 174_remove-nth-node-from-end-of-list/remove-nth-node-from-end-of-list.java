/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 16-06-15 12:43
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null || n == 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode post = dummy;
        ListNode pre = dummy;
        head = null;
        for (int i = 1; i <= n; i++) {
            post = post.next;
        }
        while (post != null && post.next != null) {
            post = post.next;
            pre = pre.next;
        }
        if (pre.next != null) {
            pre.next = pre.next.next;
        }
        return dummy.next;
    }
}
