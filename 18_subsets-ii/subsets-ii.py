# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Python
@Datetime: 16-05-09 02:22
'''

class Solution:
    """
    @param S: A set of numbers.
    @return: A list of lists. All valid subsets.
    """
    def subsetsWithDup(self, S):
        # write your code here
        S.sort()
        #Fabulous!!!
        result = [[S[n] for n in range(len(S)) if (i >> n) & 1] for i in range(2 ** len(S))]
        #Fabulous!!!
        func = lambda x, y: x if y in x else x + [y]
        result = reduce(func, [[], ] + result)
        return result