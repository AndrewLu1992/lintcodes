# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Python
@Datetime: 16-06-02 09:10
'''

class Solution:
    # @param s: A string s
    # @param dict: A dictionary of words dict
    def wordBreak(self, s, dict):
        # write your code here
        #corner case
        if len(dict) == 0:
            return len(s) == 0
        n = len(s)
        maxLength = max([len(w) for w in dict])
        f = [False] * (n + 1)
        f[0] = True
        for i in range(1, n + 1):
            for j in range(1, min(i, maxLength) + 1):
                if not f[i - j]:
                    continue
                if s[i - j:i] in dict:
                    f[i] = True
                    break
        return f[-1]
        
