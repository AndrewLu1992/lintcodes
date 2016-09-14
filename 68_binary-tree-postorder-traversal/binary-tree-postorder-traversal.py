# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-postorder-traversal
@Language: Python
@Datetime: 16-05-18 10:27
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
    @return: Postorder in ArrayList which contains node values.
    """
    def postorderTraversal(self, root):
        # write your code here
        # iterative method
        result = []
        if root is None:
            return result
        stack = []
        prev = None
        curr = root
        stack.append(root)
        while len(stack) != 0:
            curr = stack[len(stack) - 1]
            if prev is None or prev.left == curr or prev.right == curr:
                if curr.left is not None:
                    stack.append(curr.left)
                elif curr.right is not None:
                    stack.append(curr.right)
            elif curr.left == prev:
                if curr.right is not None:
                    stack.append(curr.right)
            else:
                result.append(curr.val)
                stack.pop()
            prev = curr
        return result