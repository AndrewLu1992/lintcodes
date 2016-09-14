/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/tweaked-identical-binary-tree
@Language: Java
@Datetime: 16-07-07 02:36
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
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        //Attention. Not supposed to return true
        //Otherwise it will not check subtrees of
        //equal root nodes.
        if (a.val != b.val) {
            return false;
        }
        if (isTweakedIdentical(a.left, b.left) &&
            isTweakedIdentical(a.right, b.right)) {
                return true;
            }
        if (isTweakedIdentical(a.left, b.right) &&
            isTweakedIdentical(a.right, b.left)) {
                return true;
            }
        return false;
        
    }
}