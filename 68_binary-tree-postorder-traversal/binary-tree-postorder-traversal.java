/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Java
@Datetime: 16-05-18 09:45
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        if (root == null) {
            return result;
        }
        
        stack.push(root);
        while (!stack.isEmpty()) {
           curr = stack.peek();
           if (prev == null || prev.left == curr || prev.right == curr) {
               if (curr.left != null) {
                   stack.push(curr.left);
               } else if (curr.right != null) {
                   stack.push(curr.right);
               }
           } else if (curr.left == prev) {
               if (curr.right != null) {
                   stack.push(curr.right);
               }
           } else {
               result.add(curr.val);
               stack.pop();
           }
           prev = curr;
        }
        return result;
    }
}