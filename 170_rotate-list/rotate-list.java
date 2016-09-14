/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 16-06-16 04:12
*/

/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    private int findLen(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans += 1;
            head = head.next;
        }
        return ans;
    }
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        //Find the mode of k
        k = k % findLen(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //Find the k - 1th node
        ListNode pre = dummy;
        ListNode post = dummy;
        for (int i = 1; i <= k; i++) {
            post = post.next;
        }
        while (post != null && post.next != null) {
            post = post.next;
            pre = pre.next;
        }
        post.next = dummy.next;
        dummy.next = pre.next;
        pre.next = null;
        return dummy.next;
    }
}