/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/complete-binary-tree
@Language: Java
@Datetime: 16-07-07 04:01
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
     * @return true if it is a complete binary tree, or false.
     */
    private class ReturnType {
        int depth;
        boolean isComplete;
        boolean isFull;
        public ReturnType(int depth, boolean complete, boolean isFull) {
            this.depth = depth;
            isComplete = complete;
            this.isFull = isFull;
        }
    }
    
    public boolean isComplete(TreeNode root) {
        // Write your code here
        ReturnType result = helper(root);
        return result.isComplete;
    }
    
    private ReturnType helper(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, true, true);
        }
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        if (!left.isComplete) {
            return new ReturnType(-1, false, false);
        }
        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new ReturnType(-1, false, false);
            }
            return new ReturnType(left.depth + 1, true, left.isFull);
        }
        if (left.depth == right.depth + 1) {
            if (left.isComplete && right.isFull) {
                return new ReturnType(left.depth + 1, true, false);
            }
            return new ReturnType(-1, false, false);
        }
        return new ReturnType(-1, false, false);
    }
}