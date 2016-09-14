# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/last-position-of-target
@Language: Python
@Datetime: 16-05-15 20:03
'''

class Solution:
    # @param {int[]} A an integer array sorted in ascending order
    # @param {int} target an integer
    # @return {int} an integer
    def lastPosition(self, A, target):
        # Write your code here
        if A is None or len(A) == 0:
            return -1
        start = 0
        end = len(A) - 1
        while(start + 1 < end):
            mid = start + (end - start) / 2
            if A[mid] <= target:
                start = mid
            else:
                end = mid
        if A[end] == target:
            return end
        if A[start] == target:
            return start
        return -1