# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Python
@Datetime: 16-05-29 14:11
'''

class Solution:
    """
    @param obstacleGrid: An list of lists of integers
    @return: An integer
    """
    def uniquePathsWithObstacles(self, obstacleGrid):
        # write your code here
        #corner case
        if obstacleGrid is None or len(obstacleGrid) == 0 \
            or obstacleGrid[0] is None or len(obstacleGrid[0]) == 0:
                return 1
        n = len(obstacleGrid[0])
        m = len(obstacleGrid)
        i = 0
        j = 0
        state = [[0 for _ in range(n)] for __ in range(m)]
        while i < n and obstacleGrid[0][i] == 0:
            state[0][i] = 1
            i = i + 1
        while j < m and obstacleGrid[j][0] == 0:
            state[j][0] = 1
            j = j + 1  
        for k in range(1, m):
            for z in range(1, n):
                if obstacleGrid[k][z] == 1:
                    state[k][z] = 0
                else:
                    state[k][z] = state[k - 1][z] + state[k][z - 1]
        return state[-1][-1]
