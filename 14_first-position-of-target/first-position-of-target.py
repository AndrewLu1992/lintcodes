# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Python
@Datetime: 16-05-15 19:49
'''

class Solution:
    # @param nums: The integer array
    # @param target: Target number to find
    # @return the first position of target in nums, position start from 0 
    def binarySearch(self, nums, target):
        # write your code here
        if nums is None or len(nums) == 0:
            return -1
        start = 0
        end = len(nums) - 1
        while (start + 1 < end):
            mid = start + (end - start) / 2
            if(nums[mid] == target):
                end = mid
            elif (nums[mid] < target):
                start = mid
            else:
                end = mid
        if nums[start] == target:
            return start
        if nums[end] == target:
            return end
        return -1