# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Python
@Datetime: 16-05-17 04:14
'''

class Solution:
    """
    @param A : a list of integers
    @param target : an integer to be searched
    @return : an integer
    """
    def search(self, A, target):
        # write your code here
        #corner case
        if A is None or len(A) == 0:
            return -1
        #binary search
        start = 0
        end = len(A) - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if A[mid] == target:
                return mid
            if A[mid] > A[start]:
                if target >= A[start] and target < A[mid]:
                    end = mid
                else:
                    start = mid
            else:
                if target > A[mid] and target <= A[end]:
                    start = mid
                else:
                    end = mid
        if A[start] == target:
            return start
        if A[end] == target:
            return end
        return -1