/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/middle-of-linked-list
@Language: Java
@Datetime: 16-07-13 09:34
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) { 
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode post = head.next;
        while (post != null && post.next != null) {
            pre = pre.next;
            post = post.next.next;
        }
        return pre;
    }
}