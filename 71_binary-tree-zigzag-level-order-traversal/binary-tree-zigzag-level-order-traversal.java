/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 16-07-08 04:35
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    //O(n) space and O(n) time.
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result =
            new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        //Control if it is needed to traverse from the end
        boolean zigzag = true;
        //Two stack implementation
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            while (!currentLevel.isEmpty()) {
                TreeNode curr = currentLevel.pop();
                level.add(curr.val);
                if (zigzag) {
                    if (curr.left != null) {
                        nextLevel.add(curr.left);
                    }
                    if (curr.right != null) {
                        nextLevel.add(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        nextLevel.add(curr.right);
                    }
                    if (curr.left != null) {
                        nextLevel.add(curr.left);
                    }
                }
            }
            result.add(level);
            //swap pointer of stack.
            Stack<TreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
            zigzag = !zigzag;
        }
        return result;
    }
}