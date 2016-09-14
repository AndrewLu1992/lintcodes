/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list
@Language: Java
@Datetime: 16-07-19 10:55
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //Pay attention to the null pointer problem!!
        while (head.next != null && head.next.next != null) {
            while (head.next != null && head.next.next != null
                && head.next.val == head.next.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummy.next;
    }  
}