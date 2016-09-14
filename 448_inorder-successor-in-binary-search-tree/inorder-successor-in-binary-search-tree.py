# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Python
@Datetime: 16-05-21 08:42
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    """
    @param root <TreeNode>: The root of the BST.
    @param p <TreeNode>: You need find the successor node of p.
    @return <TreeNode>: Successor of p.
    """
    def inorderSuccessor(self, root, p):
        # write your code here
        successor = None
        while root is not None and root.val != p.val:
            if root.val > p.val:
                successor = root
                root = root.left
            else:
                root = root.right
        if root is None:
            return None
        if root.right is None:
            return successor
        successor = root.right
        while successor.left is not None:
            successor = successor.left
        return successor
            