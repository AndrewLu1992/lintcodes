# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Python
@Datetime: 16-05-20 13:34
'''

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

Example of iterate a tree:
iterator = BSTIterator(root)
while iterator.hasNext():
    node = iterator.next()
    do something for node 
"""
class BSTIterator:
    #@param root: The root of binary tree.
    def __init__(self, root):
        # write your code here
        self.curr = root
        self.stack = []

    #@return: True if there has next node, or false
    def hasNext(self):
        # write your code here
        return self.curr is not None or len(self.stack) != 0

    #@return: return next node
    def next(self):
        #write your code here
        while self.curr is not None:
            self.stack.append(self.curr)
            self.curr = self.curr.left
        self.curr = self.stack.pop()
        node = self.curr
        self.curr = self.curr.right
        return node