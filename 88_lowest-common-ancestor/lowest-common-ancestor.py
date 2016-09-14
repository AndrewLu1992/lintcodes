# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor
@Language: Python
@Datetime: 16-05-19 02:04
'''

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""
import copy
class Solution:
    """
    @param root: The root of the binary search tree.
    @param A and B: two nodes in a Binary.
    @return: Return the least common ancestor(LCA) of the two nodes.
    """ 
    def lowestCommonAncestor(self, root, A, B):
        # write your code here
        # divide and conquer
        if root is None or root == A or root == B:
            return root
        left = self.lowestCommonAncestor(root.left, A, B)
        right = self.lowestCommonAncestor(root.right, A, B)
        if left is not None and right is not None:
            return root
        if left is not None:
            return left
        if right is not None:
            return right
        return None
        
