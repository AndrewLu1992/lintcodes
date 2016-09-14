/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Java
@Datetime: 16-06-15 06:37
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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    private ListNode findMiddle(ListNode head) {
       ListNode slow = head;
       ListNode fast = head.next;
       while (fast != null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;
       }
       return slow;
    }
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        tail.next = left;
        tail = getTail(tail);
        tail.next = middle;
        tail = getTail(tail);
        tail.next = right;
        return dummy.next;
    }
    //Structure Change -> Dummy Node.
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode middleDummy = new ListNode(0);
        ListNode middleTail = middleDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = rightTail.next;
            } else {
                middleTail.next = head;
                middleTail = middleTail.next;
            }
            head = head.next;
        }
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        return concat(left, middleDummy.next, right);
    }
}
