/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 16-07-08 05:04
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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result =
            new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.offer(root);
        while (!currentLevel.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            while (!currentLevel.isEmpty()) {
                TreeNode current = currentLevel.poll();
                level.add(current.val);
                if (current.left != null) {
                    nextLevel.offer(current.left);
                }
                if (current.right != null) {
                    nextLevel.offer(current.right);
                }
            }
            result.add(level);
            Queue<TreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }
        //Collections.sort and .reverse method do operation
        //in place. return void !!
        Collections.reverse(result);
        return result;
    }
}