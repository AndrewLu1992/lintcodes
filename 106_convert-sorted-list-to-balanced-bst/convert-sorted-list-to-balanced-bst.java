/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/convert-sorted-list-to-balanced-bst
@Language: Java
@Datetime: 16-06-16 08:42
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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    //Find the node at n/2 - 1 place.
    private ListNode findRoot(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //Time complexity: O(nlogn)
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode mid = findRoot(head);
        TreeNode root = new TreeNode(mid.next.val);
        TreeNode right = sortedListToBST(mid.next.next);
        mid.next = null;
        TreeNode left = sortedListToBST(head);
        root.left = left;
        root.right = right;
        return root;
    }
}
