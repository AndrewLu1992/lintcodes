/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 16-05-18 13:44
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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right != null) {
            if (root.right.left != null || root.right.right != null) {
                return false;
            } else {
                return true;
            }
        }
        if (root.right == null && root.left != null) {
            if (root.left.left != null || root.left.right != null) {
                return false;
            } else {
                return true;
            }
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right;
    }
}