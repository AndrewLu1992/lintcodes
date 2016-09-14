# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Python
@Datetime: 16-05-18 13:38
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
    @return: True if this Binary tree is Balanced, or false.
    """
    def isBalanced(self, root):
        # write your code here
        if root is None:
            return True
        if root.left is None and root.right is not None:
            if root.right.left is not None or root.right.right is not None:
                return False
            return True
        if root.right is None and root.left is not None:
            if root.left.left is not None or root.left.right is not None:
                return False
            return True
        left = self.isBalanced(root.left)
        right = self.isBalanced(root.right)
        return left and right
        