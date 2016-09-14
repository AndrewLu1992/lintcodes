/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 16-06-14 06:14
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        //corner case
        if (head == null || head.next == null) {
            return head;
        }
        //2 DummyNodes
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        // Create 2 new LinkedLists
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        // Merge 2 parts
        right.next = null;
        left.next = rightDummy.next;
        //Return
        return leftDummy.next;
    }
}
