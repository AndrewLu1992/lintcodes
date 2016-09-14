/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/nth-to-last-node-in-list
@Language: Java
@Datetime: 16-07-19 05:49
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
     * @return: Nth to last node of a singly linked list. 
     */
     /*
     * Fast slow pointer trick.
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
