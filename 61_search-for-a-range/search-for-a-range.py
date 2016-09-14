# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Python
@Datetime: 16-05-17 22:06
'''

class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be searched
    @return : a list of length 2, [index1, index2]
    """
    def searchRange(self, A, target):
        # write your code here
        # corner case
        if A is None or len(A) == 0:
            return [-1, -1]
        start = 0
        end = len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] < target:
                start = mid + 1
            else:
                end = mid
        if A[start] == target:
            lowerbound = start
        elif A[end] == target:
            lowerbound = end
        else:
            return [-1, -1]
        
        start = lowerbound
        end = len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] > target:
                end = mid - 1
            else:
                start = mid
        if A[end] == target:
            upperbound = end
        else:
            upperbound = start
        
        return [lowerbound, upperbound]
        
            
            
        
        