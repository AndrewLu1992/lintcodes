/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 16-07-22 05:30
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    //Key Point: ResultType + divide and conquer + in order traversal(DFS)
    private class ResultType {
        DoublyListNode first, last;
        public ResultType(DoublyListNode n1, DoublyListNode n2) {
            this.first = n1;
            this.last = n2;
        }
    }
    
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        ResultType result = helper(root);
        return result.first;
    }
    
    private ResultType helper(TreeNode root) {
        //Recursion exit
        if (root == null) {
            return null;
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        ResultType result = new ResultType(null, null);
        
        if (root.left == null) {
            result.first = node;
        } else {
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }
        
        if (root.right == null) {
            result.last = node;
        } else {
            result.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }
        return result;
    }
}
