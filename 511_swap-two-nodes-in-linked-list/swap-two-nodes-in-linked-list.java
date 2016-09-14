/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 16-07-20 05:46
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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNode1 = null, prevNode2 = null;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == v1) {
                prevNode1 = curr;
            }
            if (curr.next.val == v2) {
                prevNode2 = curr;
            }
            curr = curr.next;
        }
        //If there is no node with value of v1 or v2.
        if (prevNode1 == null || prevNode2 == null) {
            return head;
        }
        //Case 1: node1 is adjacent to node2.
        //Ensure that prevNode1 is ahead of prevNode2.
        if (prevNode2.next == prevNode1) {
            ListNode temp = prevNode2;
            prevNode2 = prevNode1;
            prevNode1 = temp;
        }
        ListNode node1 = prevNode1.next;
        ListNode node2 = prevNode2.next;
        //Needed for swap
        ListNode node2Next = node2.next;
        //If two nodes are neighbors
        if (prevNode1.next == prevNode2) {
            prevNode1.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        //Case2: If node1 and node2 are not adjacent
        } else {
            prevNode1.next = node2;
            node2.next = node1.next;
            
            prevNode2.next = node1;
            node1.next = node2Next;
        }
        return dummy.next;
    }
}