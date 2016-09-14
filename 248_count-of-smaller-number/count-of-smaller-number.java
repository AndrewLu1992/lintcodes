/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number
@Language: Java
@Datetime: 16-08-24 21:14
*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    //!!! value from 0 to 10000. Use this property.
    private class SegmentTreeNode {
        //remember the count of each elements.
        int count;
        int start;
        int end;
        SegmentTreeNode left, right;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.count = 0;
        }
    }
    
    private class SegmentTree {
        private SegmentTreeNode root;
        
        public SegmentTree(int begin, int fi) {
            root = new SegmentTreeNode(begin, fi);
        }
        
        public void buildTree() {
            build(root);
        }
        
        private void build(SegmentTreeNode now) {
            if (now.start == now.end) {
                return;
            }
            int mid = now.start + (now.end - now.start) / 2;
            now.left = new SegmentTreeNode(now.start, mid);
            now.right = new SegmentTreeNode(mid + 1, now.end);
            build(now.left);
            build(now.right);
        }
        
        public void updateCount(int num) {
           update(root, num); 
        }
        
        private void update(SegmentTreeNode now, int num) {
            //Modify
            if (now.start == num && now.end == num){
                now.count += 1;
                return;
            }
            //Query
            int mid = now.start + (now.end - now.start) / 2; 
            if (num <= mid) {
                update(now.left, num);
            }
            if (num > mid){
                update(now.right, num);
            }
            //Update
            now.count = (now.left.count + now.right.count);
        }
        
        public int findSmallerCount(int start, int end) {
            return find(root, start, end);
        }
        
        private int find(SegmentTreeNode now, int start, int end) {
            if (now.start == start && now.end == end) {
                return now.count;
            }
            
            int mid = now.start + (now.end - now.start) / 2;
            if (start > mid) {
                return find(now.right, start, end);
            }else if (end <= mid) {
                return find(now.left, start, end);
            } else {
                return find(now.left, start, mid) +
                    find(now.right, mid + 1, end);
            }
        }
    }
    
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        
        ArrayList<Integer> res = new ArrayList<>();
        if (A == null || queries == null || queries.length == 0) {
            return res;
        }
        
        SegmentTree tree = new SegmentTree(0, 10000);
        tree.buildTree();
        for (int num : A) {
            tree.updateCount(num);
        }
        for(int q : queries) {
            res.add(tree.findSmallerCount(0, q - 1));
        }
        return res;
    }
}
