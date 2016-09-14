/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 16-07-19 05:41
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
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int add = 0;
        while (l1 != null && l2 != null) {
            int value = (l1.val + l2.val + add) % 10;
            add = (l1.val + l2.val + add) / 10;
            p.next = new ListNode(value);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //Use loop not if
        while (l1 != null) {
            p.next = new ListNode((l1.val + add) % 10);
            add = (l1.val + add) / 10;
            p = p.next;
            l1 = l1.next;
        }
        //Use loop not if 
        while (l2 != null) {
            p.next = new ListNode((l2.val + add) % 10);
            add = (l2.val + add) / 10;
            p = p.next;
            l2 = l2.next;
        }
        if (add != 0) {
            p.next = new ListNode(add);
        }
        return dummy.next;
    }
}