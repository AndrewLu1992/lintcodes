/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 16-07-08 05:37
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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null || k2 < k1) {
            return result;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        //inorder traversal
        inorderTraverse(root, nums);
        if (k1 > nums.get(nums.size() - 1)) {
            return result;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) >= k1) {
                start = i;
                break;
            }
        }
        for (int i = start; i < nums.size(); i++) {
            end = i;
            if (nums.get(i) == k2) {
                continue;
            }
            if (nums.get(i) > k2) {
                end = i - 1;
                break;
            }
        }
        for (int i = start; i <= end; i++) {
            result.add(nums.get(i));
        }
        return result;
    }
    private void inorderTraverse(TreeNode root, ArrayList<Integer> nums) {
        if (root == null) {
            return;
        }
        inorderTraverse(root.left, nums);
        nums.add(root.val);
        inorderTraverse(root.right, nums);
    }
}