# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Python
@Datetime: 16-05-17 05:03
'''

class Solution:
    """
    @param x: An integer
    @return: The sqrt of x
    """
    def sqrt(self, x):
        #corner case
        if x == 0 or x == 1:
            return x
        start = 1
        end = x
        while start + 1 < end:
            mid = start + (end - start) / 2
            sentinel = x / mid
            if sentinel == mid:
                return mid
            elif sentinel < mid:
                end = mid
            else:
                start = mid
        return start