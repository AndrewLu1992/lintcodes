# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Python
@Datetime: 16-05-17 05:20
'''

#class SVNRepo:
#    @classmethod
#    def isBadVersion(cls, id)
#        # Run unit tests to check whether verison `id` is a bad version
#        # return true if unit tests passed else false.
# You can use SVNRepo.isBadVersion(10) to check whether version 10 is a 
# bad version.
class Solution:
    """
    @param n: An integers.
    @return: An integer which is the first bad version.
    """
    def findFirstBadVersion(self, n):
        # write your code here
        start = 1
        end = n
        while start + 1 < end:
            mid = start + (end - start) / 2
            if SVNRepo.isBadVersion(mid):
                end = mid
            else:
                start = mid
        if SVNRepo.isBadVersion(start):
            return start
        else:
            return end