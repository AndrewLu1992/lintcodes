/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 16-07-23 10:50
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
     * @param k an integer
     * @return a ListNode
     */
     
    /**
    * Measure the length of linkedList
    */
    private int size(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }
    
    /**
    * Reverse k nodes in the linkedList
    */
    private ListNode reverse(ListNode node, int k) {
        ListNode prev = null;
        while (k > 0) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
            k--;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        int len = size(head);
        int reverseNum = len / k;
        ListNode post = head;
        boolean firstTime = true;
        ListNode newHead = null;
        ListNode prev = null;
        ListNode prevEnd = null;
        // My way of processing the pointer.
        while (reverseNum > 0) {
            int i = 0;
            prev = post;
            while (i < k) {
                post = post.next;
                i++;
            }
            head = reverse(prev, k);
            if (prevEnd != null) {
                prevEnd.next = head;
            }
            if (firstTime) {
                newHead = head;
                firstTime = false;
            }
            reverseNum--;
            prevEnd = prev;
        }
        prevEnd.next = post;
        return newHead;
    }
}