# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal
@Language: Python
@Datetime: 16-05-21 07:41
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
    @return: Level order in a list of lists of integers
    """
    #BFS
    def levelOrder(self, root):
        # write your code here
        result = []
        if root is None:
            return result
        q = [root]
        while len(q) != 0:
            new_q = []
            result.append([node.val for node in q])
            for node in q:
                if node.left is not None:
                    new_q.append(node.left)
                if node.right is not None:
                    new_q.append(node.right)
            q = new_q
        return result