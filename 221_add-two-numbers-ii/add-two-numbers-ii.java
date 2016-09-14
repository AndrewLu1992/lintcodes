/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/add-two-numbers-ii
@Language: Java
@Datetime: 16-07-21 02:26
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
           ListNode temp = head.next;
           head.next = prev;
           prev = head;
           head = temp;
        }
        return prev;
    }
    
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        l1 = reverse(l1);
        l2 = reverse(l2);
        int addOn = 0;
        
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + addOn;
            int digit = value % 10;
            addOn = value / 10;
            p.next = new ListNode(digit);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            p.next = new ListNode((addOn + l1.val) % 10);
            addOn = (addOn + l1.val) / 10;
            p = p.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            p.next = new ListNode((addOn + l2.val) % 10);
            addOn = (addOn + l2.val) / 10;
            p = p.next;
            l2 = l2.next;
        }
        
        if (addOn != 0) {
            p.next = new ListNode(addOn);
        }
        
        return reverse(dummy.next);
    }  
}