# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Python
@Datetime: 16-05-19 10:54
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
    @return: True if the binary tree is BST, or false
    """ 
    def isValidBST(self, root):
        # write your code here
        self.values = []
        self.traverse(root)
        for i in range(len(self.values) - 1):
            if self.values[i] >= self.values[i+1]:
                return False
        return True
    
    def traverse(self, root):
        if root is None:
            return
        self.traverse(root.left)
        self.values.append(root.val)
        self.traverse(root.right)
         
    
    
        
        