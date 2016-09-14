# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/edit-distance
@Language: Python
@Datetime: 16-06-08 10:02
'''

class Solution: 
    # @param word1 & word2: Two string.
    # @return: The minimum number of steps.
    def minDistance(self, word1, word2):
        # write your code here
        if word1 is None or word2 is None:
            return 0
        m = len(word1)
        n = len(word2)
        f = [[0 for j in range(n + 1)] for i in range(m + 1)]
        for i in range(m + 1):
            f[i][0] = i
        for j in range(n + 1):
            f[0][j] = j
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if word1[i - 1] == word2[j - 1]:
                    f[i][j] = min(f[i - 1][j - 1], f[i - 1][j] + 1, f[i][j - 1] + 1)
                else:
                    f[i][j] = min(f[i - 1][j - 1] + 1, f[i - 1][j] + 1, f[i][j - 1] + 1)
        return f[m][n]
        