# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Python
@Datetime: 16-05-08 22:42
'''

class Solution:
    """
    @param S: The set of numbers.
    @return: A list of lists. See example.
    """
    def subsets(self, S):
        # write your code here
        self.result = []
        if S is None or len(S) == 0:
            return [[]]
        self.search(sorted(S), [], 0)
        return self.result
    
    def search(self, S, subset, pos):
        if pos == len(S):
            self.result.append(subset)
            return
        self.search(S, subset+[S[pos]], pos+1)
        self.search(S, subset, pos+1)
            