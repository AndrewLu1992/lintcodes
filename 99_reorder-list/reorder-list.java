/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Java
@Datetime: 16-06-15 07:32
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
     * @param head: The head of linked list.
     * @return: void
     */
    /*1. Reverse the right half of the list
      2. Merge The left half list and the reversed right half.
    */
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //Structure changed -> Dummy Node.
    //!!! important!!!
    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode post = dummy.next;
        while (post != null) {
            ListNode temp = post.next;
            post.next = pre;
            pre = post;
            post = temp;
        }
        dummy.next = pre;
        head.next = null;
        return dummy.next;
    }
    //Merge
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        boolean linkLeft = true;
        
        while (left != null && right != null) {
            if (linkLeft) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            linkLeft = !linkLeft;
            tail = tail.next;
        }
        if (left != null) {
            tail.next = left;
        } else {
            tail.next = right;
        }
        return dummy.next;
    }
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode right = reverse(mid.next);
        mid.next = null;
        merge(head, right);
    }
}
