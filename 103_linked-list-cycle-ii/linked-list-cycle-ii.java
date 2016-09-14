/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/linked-list-cycle-ii
@Language: Java
@Datetime: 16-06-15 17:30
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        //slow-fast pointer
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        boolean init = true;
        while (fast != slow || init) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            init = false;
        }
        fast = head;
        // fast == slow.next!!!
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
