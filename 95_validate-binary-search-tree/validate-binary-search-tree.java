/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Java
@Datetime: 16-05-20 01:26
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
     * @return: True if the binary tree is BST, or false
     */
     // traverse
    private class ResultType {
        boolean isValid;
        int maxValue;
        int minValue;
        public ResultType(boolean valid, int max, int min) {
            this.isValid = valid;
            this.maxValue = max;
            this.minValue = min;
        }
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isValid || !right.isValid) {
            return new ResultType(false, 0, 0);
        }
        if (root.left != null && left.maxValue >= root.val || 
            root.right != null && right.minValue <= root.val) {
            return new ResultType(false, 0, 0);
        }
        return new ResultType(true, Math.max(root.val, right.maxValue),
            Math.min(root.val, left.minValue));
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root).isValid;
    }
}