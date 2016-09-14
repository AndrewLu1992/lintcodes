# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Python
@Datetime: 16-06-08 04:58
'''

class Solution:
    # @param A, B: Two string.
    # @return: the length of the longest common substring.
    def longestCommonSubstring(self, A, B):
        # write your code here
        # corner case
        if A is None or len(A) == 0 or B is None or len(B) == 0:
            return 0
        m = len(A)
        n = len(B)
        f = [[0 for j in range(n + 1)] for i in range(m + 1)]
        ans = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                if A[i - 1] == B[j - 1]:
                    if f[i - 1][j - 1] == 0:
                        f[i][j] = 1
                    else:
                        f[i][j] = f[i - 1][j - 1] + 1
                # find the maximum length through whole pair of substrings.
                # If not continous, reset to 0.
                if f[i][j] > ans:
                    ans = f[i][j]
        return ans
                    
                        
                        
        
                        
                