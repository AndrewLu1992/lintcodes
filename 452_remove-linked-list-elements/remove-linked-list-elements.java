/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/remove-linked-list-elements
@Language: Java
@Datetime: 16-07-13 09:47
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        //Pay attention to p which may be null.
        while (p != null && p.next != null) {
           while (p.next != null && p.next.val == val) {
               p.next = p.next.next;
           }
           p = p.next;
        }
        return dummy.next;
    }
}