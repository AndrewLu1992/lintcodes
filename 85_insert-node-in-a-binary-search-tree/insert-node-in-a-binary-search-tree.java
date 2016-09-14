/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/insert-node-in-a-binary-search-tree
@Language: Java
@Datetime: 16-07-07 04:15
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
 */
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            root = node;
            return root;
        }
        TreeNode p = root;
        TreeNode parent = root;
        boolean isLeft = true; 
        while (p != null) {
            parent = p;
            if (node.val < p.val) {
                p = p.left;
                isLeft = true;
            } else {
                p = p.right;
                isLeft = false;
            }
        }
        if (isLeft) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }
}