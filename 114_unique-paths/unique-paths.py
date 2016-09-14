# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/unique-paths
@Language: Python
@Datetime: 16-05-27 05:04
'''

class Solution:
    """
    @param n and m: positive integer(1 <= n , m <= 100)
    @return an integer
    """ 
    def uniquePaths(self, m, n):
        # write your code here
        if m == 0 or n == 0:
            return 1
        table = [[1 for j in range(n)] for i in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                table[i][j] = table[i - 1][j] + table[i][j - 1]
        return table[-1][-1]
        