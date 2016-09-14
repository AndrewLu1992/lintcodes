/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/symmetric-binary-tree
@Language: Java
@Datetime: 16-07-07 02:48
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
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }
    private boolean check(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        if (r1.val != r2.val) {
            return false;
        }
        return check(r1.left, r2.right) && check(r1.right, r2.left);
    }
}