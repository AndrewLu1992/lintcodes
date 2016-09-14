# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/minimum-depth-of-binary-tree
@Language: Python
@Datetime: 16-05-18 13:27
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
    def minDepth(self, root):
        # write your code here
        if root is None:
            return 0
        left = self.minDepth(root.left)
        right = self.minDepth(root.right)
        if left == 0 and right != 0:
            return right + 1
        if right == 0 and left != 0:
            return left + 1
        if left < right:
            return left + 1
        return right + 1