/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Java
@Datetime: 16-07-07 14:49
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder == null || inorder == null
            || preorder.length == 0 || inorder.length == 0
                || preorder.length != inorder.length) {
                    return null;
                }
        return build(preorder, 0, preorder.length - 1,
            inorder, 0, inorder.length - 1);
    }
    //We need to find the position of the root to measure 
    //the amount of nodes used to construct left and right subtrees.
    private int findPosition(int[] arr, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    //Recursion on left and right side of array divided by
    //the position of the root value.
    private TreeNode build(int[] preorder, int prestart, int preend,
        int[] inorder, int instart, int inend) {
            if (instart > inend) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[prestart]);
            int position = findPosition(inorder, instart,
                inend, preorder[prestart]);
            root.left = build(preorder, prestart + 1,
                prestart + position - instart,
                inorder, instart, position - 1);
            root.right = build(preorder, prestart + position - instart + 1,
                preend, inorder, position + 1, inend);
            return root;     
    }
}