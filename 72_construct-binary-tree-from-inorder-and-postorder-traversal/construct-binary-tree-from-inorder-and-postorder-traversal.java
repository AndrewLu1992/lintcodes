/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal
@Language: Java
@Datetime: 16-07-07 15:39
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder == null || postorder == null
            || inorder.length == 0 || postorder.length == 0
            || inorder.length != postorder.length) {
                return null;
            }
        return build(inorder, 0, inorder.length - 1,
            postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int instart, int inend,
        int[] postorder, int poststart, int postend) {
            if (instart > inend) {
                return null;
            }
            int position = findPosition(inorder, instart, inend,
                postorder[postend]);
            TreeNode root = new TreeNode(postorder[postend]);
            root.left = build(inorder, instart, position - 1,
            //Note poststart + position - instart need minus 1.
            //This is because the last num always be the root of subtree.
            //Note the boundray decision problem.
                postorder, poststart, poststart + position - instart - 1);
            root.right = build(inorder, position + 1, inend,
                postorder, poststart + position - instart, postend - 1);
            return root;
        }
    private int findPosition(int[] arr, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}