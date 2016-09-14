# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Python
@Datetime: 16-05-18 04:52
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
    @return: Preorder in ArrayList which contains node values.
    """
    def preorderTraversal(self, root):
        # write your code here
        # divide and conquer
        if root is None:
            return []
        return [root.val] + self.preorderTraversal(root.left) +\
        self.preorderTraversal(root.right)
            
        