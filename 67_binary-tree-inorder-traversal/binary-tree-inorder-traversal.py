# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-inorder-traversal
@Language: Python
@Datetime: 16-05-18 04:49
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
    @return: Inorder in ArrayList which contains node values.
    """
    def inorderTraversal(self, root):
        # write your code here
        #corner case
        if root is None:
            return []
        #divide and conquer
        return self.inorderTraversal(root.left) + [root.val] + \
        self.inorderTraversal(root.right)