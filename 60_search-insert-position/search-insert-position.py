# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Python
@Datetime: 16-05-16 05:48
'''

class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be inserted
    @return : an integer
    """
    def searchInsert(self, A, target):
        # write your code here
        #corner case
        if A is None or len(A) == 0:
            return 0
        start = 0
        end = len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] == target:
                return mid
            elif A[mid] < target:
                start = mid
            else:
                end = mid
                
        if A[start] >= target:
            return start
        elif A[end] < target:
            return end + 1
        else:
            return start + 1