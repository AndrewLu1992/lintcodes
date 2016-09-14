/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/segment-tree-build
@Language: Java
@Datetime: 16-08-23 21:58
*/

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) {
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        
        if (start < end) {
            int mid = start + (end - start) / 2;
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }
        
        return root;
    }
}