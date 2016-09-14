# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Python
@Datetime: 16-05-27 05:16
'''

class Solution:
    """
    @param n: An integer
    @return: An integer
    """
    def climbStairs(self, n):
        # write your code here
        if n == 0:
            return 1
        arr = [i for i in range(1, n+1)]
        for i in range(3, n):
            arr[i] = arr[i - 1] + arr[i - 2]
        return arr[n - 1]
