/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list
@Language: Java
@Datetime: 16-08-01 11:02
*/

public class Queue {
    private class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int value, ListNode next, ListNode prev) {
            val = value;
            this.next = next;
            this.prev = prev;
        }
    }
    
    private ListNode head;
    
    private ListNode tail;
    
    public Queue() {
        // do initialize if necessary
        head = tail = null;
    }

    public void enqueue(int item) {
        // Write your code here
        if (tail == null) {
            head = new ListNode(item, null, null);
            tail = head;
        } else {
            tail.next = new ListNode(item, null, tail);
            tail = tail.next;
        }
    }

    public int dequeue() {
        // Write your code here
        if (head != null) {
            int res = head.val;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                head = tail = null;
            }
            return res;
        }
        return -1;
    }
}