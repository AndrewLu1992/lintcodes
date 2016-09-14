/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/remove-node-in-binary-search-tree
@Language: Java
@Datetime: 16-07-09 03:10
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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        //Because structure of tree is changed, we need a dummy node.
        if (root == null) {
            return null;
        }
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findParent(dummy, root, value);
        TreeNode node = null;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return root;
        }
        delete(parent, node);
        return dummy.left;
    }
    
    /**Find the parent of the given target value.*/
    private TreeNode findParent(TreeNode parent, TreeNode child, int target) {
        if (child == null) {
            return parent;
        }
        if (child.val == target) {
            return parent;
        }
        if (child.val > target) {
            return findParent(child, child.left, target);
        } else {
            return findParent(child, child.right, target);
        }
    }
    
    /**Delete the node. 3 situations:
    1. node.left == null && node.right == null. Delete node directly.
    2. node.left == null || node.right == null. Move up the corresponding
    subtree to the corresponding parent.
    3. If node.left != null && node.right != null. Then we find the smallest
    number in the right subtree which is the closest number that is bigger
    than the node. Set the value of node to be the number and delete the
    treenode fro the right subtree.*/
    private void delete(TreeNode parent, TreeNode target) {
        if (target.left == null && target.right == null) {
            if (parent.left != null && parent.left == target) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (target.left != null && target.right == null) {
            if (parent.left != null && parent.left == target) {
                parent.left = target.left;
            } else {
                parent.right = target.left;
            }
        } else if (target.right != null && target.left == null) {
            if (parent.left != null && parent.left == target) {
                parent.left = target.right;
            } else {
                parent.right = target.right;
            }
        } else {
            TreeNode father = target;
            TreeNode temp = target.right;
            while (temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            target.val = temp.val;
            father.left = temp.right;
        }
    }
}