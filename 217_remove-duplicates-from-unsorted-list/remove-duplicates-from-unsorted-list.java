/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-unsorted-list
@Language: Java
@Datetime: 16-07-13 10:00
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if (head == null) {
            return head;
        }
        HashSet<Integer> buffer = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
            //If there is a duplicates. Then we remove it and continue.
            if (buffer.contains(p.next.val)) {
                int target = p.next.val;
                while (p.next != null && p.next.val == target) {
                    p.next = p.next.next;
                }
                continue;
            }
            if (p.next != null)
                buffer.add(p.next.val);
            p = p.next;
        }
        return dummy.next;
    }  
}