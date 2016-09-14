# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Python
@Datetime: 16-05-17 20:57
'''

class Solution:
    #@param A: An integers list.
    #@return: return any of peek positions.
    def findPeak(self, A):
        # write your code here
        #corner case
        if A is None or len(A) < 3:
            return -1
        start = 0
        end = len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] > A[mid - 1] and A[mid] > A[mid+1]:
                return mid
            elif A[mid] > A[mid - 1] and A[mid] < A[mid + 1]:
                start = mid
            else:
                end = mid
        return -1
            