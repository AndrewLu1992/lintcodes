# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Python
@Datetime: 16-05-27 03:45
'''

class Solution:
    """
    @param grid: a list of lists of integers.
    @return: An integer, minimizes the sum of all numbers along its path
    """
    def minPathSum(self, grid):
        # write your code here
        table = [[grid[0][0]]]
        for i in range(1, len(grid[0])):
            table[0].append(table[0][i - 1] + grid[0][i])
        for i in range(1, len(grid)):
            table.append([table[i - 1][0] + grid[i][0]])
        for i in range(1, len(grid)):
            for j in range(1, len(grid[0])):
                table[i].append(min(table[i - 1][j], table[i][j - 1]) \
                    + grid[i][j])
        return table[-1][-1]