# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/identical-binary-tree
@Language: Python
@Datetime: 16-05-21 08:54
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
    @param a, b, the root of binary trees.
    @return true if they are identical, or false.
    """
    #Divide and Conquer
    def isIdentical(self, a, b):
        # Write your code here
        if a is None and b is not None:
            return False
        if a is not None and b is None:
            return False
        if a is None and b is None:
            return True
        if a.val == b.val:
            return self.isIdentical(a.left, b.left) and \
                self.isIdentical(a.right, b.right)
        else:
            return False