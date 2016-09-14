# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning-ii
@Language: Python
@Datetime: 16-06-07 07:24
'''

class Solution:
    # @param s, a string
    # @return an integer
    def getIsPalindrome(self, s):
        isPalindrome = [[True if i == j else False\
            for j in range(len(s))] for i in range(len(s))]
        for i in range(0, len(s) - 1):
            isPalindrome[i][i + 1] = s[i] == s[i + 1]
        for l in range(2, len(s)):
            for start in range(len(s) - l):
                isPalindrome[start][start + l] =\
                    isPalindrome[start + 1][start + l - 1] and\
                    s[start] == s[start + l]
        return isPalindrome
    
    def minCut(self, s):
        if s is None or len(s) == 0:
            return 0
        f = [i for i in range(len(s) + 1)]
        isPalindrome = self.getIsPalindrome(s)
        for i in range(1, len(s) + 1):
            for j in range(i):
                if isPalindrome[j][i - 1]:
                    f[i] = min(f[i], f[j] + 1)
        return f[len(s)] - 1
                    
        