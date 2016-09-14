# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Python
@Datetime: 16-05-29 08:06
'''

class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        # write your code here
        if A is None or len(A) == 0:
            return 0
        start = 0
        end = 0
        step = 0
        #greedy algorithm
        # O(1) space and O(n^2) worst case time
        while end < len(A) - 1:
            step = step + 1
            farthest = end
            for i in range(start, end + 1):
                if A[i] + i > farthest:
                    farthest = A[i] + i
            start = end + 1
            end = farthest
        return step
            