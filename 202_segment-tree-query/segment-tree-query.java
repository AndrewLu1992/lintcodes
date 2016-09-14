/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/segment-tree-query
@Language: Java
@Datetime: 16-08-23 22:18
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
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.max;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return query(root.left, start, end);
            } else if (start >= mid + 1) {
                return query(root.right, start, end);
            } else {
                return Math.max(query(root.left, start, mid),
                    query(root.right, mid + 1, end));
            }
        }
    }
}