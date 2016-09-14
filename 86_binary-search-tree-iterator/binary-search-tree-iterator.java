/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Java
@Datetime: 16-05-20 13:44
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    private TreeNode curr;
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        // write your code here
        curr = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return curr != null || !stack.isEmpty();
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        TreeNode node = stack.pop();
        curr = node.right;
        return node;
    }
}