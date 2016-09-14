/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/palindrome-linked-list
@Language: Java
@Datetime: 16-07-22 02:41
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
     * @return a boolean
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    private boolean checkSame(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return false;
        }
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return true;
        }
        /**
         * Find the middle by fast-slow pointer.
         * We want find the node previous to the middle
         * thus place the fast pointer one node latter.
         */
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        boolean isOdd = fast == null ? false : true;
        ListNode postHalf = null;
        if (isOdd) {
            postHalf = slow.next.next;
        } else {
            postHalf = slow.next;
        }
        
        slow.next = null;
        postHalf = reverse(postHalf);
        return checkSame(head, postHalf);
    }
}