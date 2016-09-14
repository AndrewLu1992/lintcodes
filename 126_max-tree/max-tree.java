/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/max-tree
@Language: Java
@Datetime: 16-08-03 09:59
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        
        for (int i = 0; i <= A.length; i++) {
            
            TreeNode rightFirstBigger = i == A.length? 
                new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
            //O(n) space. O(n) time.   
            while (!stack.empty()) {
                
               TreeNode curr = stack.peek();
               
               if (rightFirstBigger.val > curr.val) {
                   stack.pop();
                   if (stack.empty()) {
                       rightFirstBigger.left = curr;
                   } else {
                       TreeNode leftFirstBigger = stack.peek();
                       if (leftFirstBigger.val > rightFirstBigger.val) {
                           rightFirstBigger.left = curr;
                       } else {
                           leftFirstBigger.right = curr;
                       }
                   }
               } else {
                   break;
               }
            }
            
            stack.push(rightFirstBigger);
        }
        
        return stack.pop().left;
    }
}