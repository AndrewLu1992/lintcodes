# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Python
@Datetime: 16-05-17 20:38
'''

class Solution:
    """
    @param L: Given n pieces of wood with length L[i]
    @param k: An integer
    return: The maximum length of the small pieces.
    """
    def woodCut(self, L, k):
        # write your code here
        #corner case
        if sum(L) < k:
            return 0
        start = 1
        end = max(L)
        #Find the longest length that gives more than k pieces
        while start + 1 < end:
            mid = start + (end - start) / 2
            pieces = sum([l/mid for l in L])
            if pieces >= k:
                start = mid
            else:
                end = mid
        if sum([l/end for l in L]) >= k:
            return end
        return start
        