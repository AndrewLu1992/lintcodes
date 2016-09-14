# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Python
@Datetime: 16-05-19 02:23
'''

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""
class Solution:
    """
    @param root the root of binary tree.
    @return an integer
    """
    def maxPathSum2(self, root):
        # Write your code here
        if root is None:
            return 0
        left = self.maxPathSum2(root.left)
        right = self.maxPathSum2(root.right)
        return max(max(left, right), 0) + root.val
                