/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Java
@Datetime: 16-05-18 04:46
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        //corner case
        if (root == null) {
           return result; 
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curl = root;
        while (!stack.isEmpty() || curl != null) {
            while (curl != null) {
                stack.push(curl);
                curl = curl.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            curl = node.right;
        }
        return result;
    }
}