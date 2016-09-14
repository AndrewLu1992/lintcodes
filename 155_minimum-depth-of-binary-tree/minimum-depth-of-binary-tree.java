/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/minimum-depth-of-binary-tree
@Language: Java
@Datetime: 16-05-18 13:24
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
    public int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if (left == 0 && right != 0) {
            return right + 1;
        }
        if (right == 0 && left != 0) {
            return left + 1;
        }
        if (left < right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
}