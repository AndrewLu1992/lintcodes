# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Python
@Datetime: 16-05-19 03:43
'''

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""
class Solution:
    """
    @param root: The root of binary tree.
    @return: An integer
    """
    def maxPathSum(self, root):
        # write your code here
        maxsum, _ = self.helper(root)
        return maxsum
        
    def helper(self, root):
        if root is None:
            return -sys.maxint, 0
        left = self.helper(root.left)
        right = self.helper(root.right)
        single = max(left[1]+root.val, right[1]+root.val, 0)
        maxpath = max(left[0], right[0], left[1] + right[1] + root.val)
        return maxpath, single
            
        