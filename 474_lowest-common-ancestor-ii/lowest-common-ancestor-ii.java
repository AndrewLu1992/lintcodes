/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-ii
@Language: Java
@Datetime: 16-07-06 05:16
*/

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        if (A.parent == null || B.parent == null) {
            return A.parent == null ? A : B;
        }
        int depthA = 0;
        ParentTreeNode pA = A;
        int depthB = 0;
        ParentTreeNode pB = B;
        //Firstly, we calculate the depth of both node A and B.
        while (pA.parent != null) {
           pA = pA.parent;
           depthA++;
        }
        while (pB.parent != null) {
            pB = pB.parent;
            depthB++;
        }
        //Find the LCA using each depth.
        while (A != B) {
            if (depthA > depthB) {
                A = A.parent;
                depthA--;
            } else if (depthA < depthB) {
                B = B.parent;
                depthB--;
            } else {
                A = A.parent;
                B = B.parent;
            }
        }
        return A;
    }
}
