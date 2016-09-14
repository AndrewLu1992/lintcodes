/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 16-07-06 03:03
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    //DFS O(N) space. O(N) time.
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, target, path, result);
        return result;
    }
    private void dfs(TreeNode node, int target, ArrayList<Integer> path,
        ArrayList<List<Integer>> result) {
            //Recursion should be rewinded at the leaf node.
            //not the null node. 
            if (node.left == null && node.right == null) {
                if (sum(path) + node.val == target) {
                    path.add(node.val);
                    result.add(new ArrayList<Integer>(path));
                    //We need to remove leaf node afterwards.
                    path.remove(path.size() - 1);
                }
                return;
            }
            path.add(node.val);
            //Prevent passing in a null value.
            if (node.left != null) {
                dfs(node.left, target, path, result);
            }
            //Prevent passing in a null value.
            if (node.right != null) {
                dfs(node.right, target, path, result);
            }
            path.remove(path.size() - 1);
        }
    private int sum(ArrayList<Integer> path) {
        int sum = 0;
        for (Integer num : path) {
            sum += num;
        }
        return sum;
    }
}