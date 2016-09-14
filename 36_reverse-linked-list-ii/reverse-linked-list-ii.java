/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 16-06-14 05:49
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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        // corner case
        if (m >= n || head == null || head.next == null) {
            return head;
        }
        //create a dummy node.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //Move head to position m - 1.
        for (int i = 1; i < m; i++) {
            head = head.next;
        }
        //Nodes for reversion
        ListNode pre = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode post = nNode.next;
        //Reversion
        for (int i = m; i < n; i++) {
            ListNode temp = post.next;
            post.next = nNode;
            nNode = post;
            post = temp;
        }
        //Process m - 1 and n + 1 Link 
        mNode.next = post;
        pre.next = nNode;
        //Return the answer
        return dummy.next;
    }
}