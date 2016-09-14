# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Python
@Datetime: 16-05-28 04:12
'''

class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        # write your code here
        # greedy algorithm, keep finding the farthest index
        if A is None or len(A) == 0:
            return True
        farthest = A[0]
        for i in range(1, len(A)):
            if i <= farthest and i + A[i] > farthest:
                farthest = i + A[i]
        return farthest >= len(A) - 1
        