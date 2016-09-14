/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 16-07-14 04:41
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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        while (head != null) {
            //Each time we find the min node that is smaller than the target.
            //Needed to search from the head.
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            //Pay attention to the insertion processing.
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }
}