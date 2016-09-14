/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 16-05-19 08:35
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
     * @return: An integer.
     */
    private class returnType{
        int single;
        int maxpath;
        public returnType (int single, int maxpath) {
            this.single = single;
            this.maxpath = maxpath;
        }
    }
    private returnType helper(TreeNode root) {
        if (root == null) {
            return new returnType(0, Integer.MIN_VALUE);
        }
        returnType left = helper(root.left);
        returnType right = helper(root.right);
        int single = Math.max(0, Math.max(left.single + root.val, right.single + root.val));
        int maxpath = Math.max(left.single + right.single + root.val, Math.max(left.maxpath, right.maxpath));
        return new returnType(single, maxpath);
    }
    public int maxPathSum(TreeNode root) {
        // write your code here
        return helper(root).maxpath;
    }
}