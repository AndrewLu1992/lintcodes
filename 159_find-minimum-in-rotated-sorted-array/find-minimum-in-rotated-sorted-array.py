# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Python
@Datetime: 16-05-16 14:27
'''

class Solution:
    # @param num: a rotated sorted array
    # @return: the minimum number in the array
    def findMin(self, num):
        # write your code here
        # corner case
        if num is None or len(num) == 0:
            return -1
        target = num[len(num) - 1]
        start = 0
        end = len(num) - 1
        # find the first element that is smaller than/equal to the target
        while start + 1 < end:
            mid = start + (end - start) / 2
            if num[mid] <= target:
                end = mid
            else:
                start = mid
        if num[start] < num[end]: 
            return num[start]
        else:
            return num[end]
            