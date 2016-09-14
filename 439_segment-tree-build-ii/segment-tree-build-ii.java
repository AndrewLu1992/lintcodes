/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/segment-tree-build-ii
@Language: Java
@Datetime: 16-08-24 03:01
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
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(0, A.length - 1, Integer.MIN_VALUE);
        buildTree(root, A);
        return root;
    }
    
    private void buildTree(SegmentTreeNode now, int[] A) {
        int start = now.start;
        int end = now.end;
        int mid = now.start + (now.end - now.start) / 2;
        
        if (start == end) {
            now.max = A[start];
            return;
        }
        
        if (start < end) {
            now.left = new SegmentTreeNode(start, mid, Integer.MIN_VALUE);
            now.right = new SegmentTreeNode(mid + 1, end, Integer.MIN_VALUE);
            buildTree(now.left, A);
            buildTree(now.right, A);
            if (now.left != null && now.right != null) {
                now.max = Math.max(now.left.max, now.right.max);
            }
        }
    }
}