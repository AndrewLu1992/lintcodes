/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/interval-minimum-number
@Language: Java
@Datetime: 16-08-24 00:44
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    private class SegmentTreeNode {
        int min;
        int start;
        int end;
        SegmentTreeNode left = null;
        SegmentTreeNode right = null;
        
        public SegmentTreeNode(int start, int end) {
           this.start = start;
           this.end = end;
        }
    }
    
    private class SegmentTree {
        private SegmentTreeNode root;
        
        public SegmentTree(int[] A) {
            root = new SegmentTreeNode(0, A.length - 1);
            build(root, A);
        }
        
        public void build(SegmentTreeNode now, int[] A) {
            int start = now.start;
            int end = now.end;
            if (start == end) {
                now.min = A[start];
                return;
            }
            
            if (start < end) {
                int mid = start + (end - start) / 2;
                now.left = new SegmentTreeNode(start, mid);
                now.right = new SegmentTreeNode(mid + 1, end);
                build(now.left, A);
                build(now.right, A);
                //System.out.println(now.left.min + " and " + now.right.min);
                now.min = Math.min(now.left.min, now.right.min);
            }
        }
        
        public int find(int start, int end) {
            return findMin(root, start, end);
        }
        
        private int findMin(SegmentTreeNode now, int start, int end) {
            int mid = now.start + (now.end - now.start) / 2;
            //Attention: not confuse now and root.
            if (start == now.start && end == now.end) {
                return now.min;
            } else if (end <= mid) {
                return findMin(now.left, start, end);
            } else if (start > mid) {
                return findMin(now.right, start, end);
            } else {
                return Math.min(findMin(now.left, start, mid),
                    findMin(now.right, mid + 1, end));
            }
        }
    }
    
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        SegmentTree tree = new SegmentTree(A);
        for (Interval inter : queries) {
            res.add(tree.find(inter.start, inter.end));
        }
        return res;
    }
}