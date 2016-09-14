/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/interval-sum
@Language: Java
@Datetime: 16-08-24 16:58
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
    //Use segment tree.
    private class SegmentTreeNode {
        long sum;
        int start;
        int end;
        SegmentTreeNode left, right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private class SegmentTree {
        private SegmentTreeNode root;
        private int[] A;
        
        public SegmentTree(int[] A) {
            root = new SegmentTreeNode(0, A.length - 1);
            this.A = A;
        }
        
        public void buildTree() {
            build(root, A);
        }
        
        private void build(SegmentTreeNode now, int[] A) {
            if (now == null || now.start > now.end){
                return;
            }
            
            if (now.start == now.end) {
                now.sum = A[now.start];
                return;
            }
            
            int mid = now.start + (now.end - now.start) / 2;
            
            now.left = new SegmentTreeNode(now.start, mid);
            now.right = new SegmentTreeNode(mid + 1, now.end);
            build(now.left, A);
            build(now.right, A);
            now.sum = now.left.sum + now.right.sum;
        }
        
        public long findSum(int start, int end) {
            return find(root, start, end);
        }
        
        private long find(SegmentTreeNode now, int start, int end) {
            if (now == null || start > end) {
                return Integer.MIN_VALUE;
            }
            if (now.start == start && now.end == end) {
                return now.sum;
            }
            int mid = now.start + (now.end - now.start) / 2;
            if (end <= mid) {
                return find(now.left, start, end);
            }else if (start > mid) {
                return find(now.right, start, end);
            }else {
                return find(now.left, start, mid) +
                    find(now.right, mid + 1, end);
            }
        }
    }
    
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        
        SegmentTree tree = new SegmentTree(A);
        //Build Tree O(n) time.
        tree.buildTree();
        
        for (Interval inter : queries) {
            //Tree Query: O(logn) time.
            res.add(tree.findSum(inter.start, inter.end));
        }
        return res;
    }
}
