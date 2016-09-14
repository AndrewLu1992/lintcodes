/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list-ii
@Language: Java
@Datetime: 16-08-01 10:53
*/

public class Dequeue {
    
    //Double LinkedList + Queue principle.
    private class ListNode {
        int value;
        ListNode next;
        ListNode prev;
        public ListNode(int value, ListNode next, ListNode prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
    
    private ListNode head;
    private ListNode tail;
    
    public Dequeue() {
        // do initialize if necessary
        head = null;
        tail = null;
    }

    public void push_front(int item) {
        // Write your code here
        if (head == null) {
            head = new ListNode(item, null, null);
            tail = head;
        } else {
            head.prev = new ListNode(item, head, null);
            head = head.prev;
        }
    }

    public void push_back(int item) {
        // Write your code here
        if (tail == null) {
            head = new ListNode(item, null, null);
            tail = head;
        } else {
            tail.next = new ListNode(item, null, tail);
            tail = tail.next;
        }
    }

    public int pop_front() {
        // Write your code here
        if (head != null) {
            int res = head.value;
            head = head.next;
            //Attention!! pointer tail process.
            if (head != null) {
                head.prev = null;
            } else {
                //Otherwise the only node is not removed.
                tail = null;
            }
            return res;
        }
        return -1;
    }

    public int pop_back() {
        // Write your code here
        if (tail != null) {
            int res = tail.value;
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;
            }
            return res;
        }
        return -1;
    }
}