/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/segment-tree-modify
@Language: Java
@Datetime: 16-08-23 23:29
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root == null || index < root.start || index > root.end) {
            return;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        
        if (index < mid) {
            modify(root.left, index, value);
        } else if (index > mid) {
            modify(root.right, index, value);
        } else if (index == mid && root.start != root.end) {
            modify(root.left, index, value);
        }
        else {
            root.max = value;
        }
        //Point !!! top -> down approach query finding element.
        //bottom - up update max values.
        //Donot update max values beforehand.
        //Traversal + backtrack.
        if (root.left != null && root.right != null)
            root.max = Math.max(root.left.max, root.right.max);
    }
}