/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Java
@Datetime: 16-05-21 08:36
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        //Firstly, find the parent closest to p
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successor;
        }
        successor = root.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        return successor;
    }
}