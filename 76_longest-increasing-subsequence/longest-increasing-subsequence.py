# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Python
@Datetime: 16-05-29 11:14
'''

class Solution:
    """
    @param nums: The integer array
    @return: The length of LIS (longest increasing subsequence)
    """
    def longestIncreasingSubsequence(self, nums):
        # write your code here
        if nums is None or len(nums) == 0:
            return 0
        arr = [1 for i in range(len(nums))]
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[j] <= nums[i] and arr[i] < arr[j] + 1:
                    arr[i] = arr[j] + 1
        return max(arr)