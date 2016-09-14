# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Python
@Datetime: 16-05-16 06:50
'''

"""
Definition of ArrayReader:
class ArrayReader:
    def get(self, index):
        # this would return the number on the given index
        # if there is no number on that index, return -1
"""
class Solution:
    # @param {ArrayReader} reader: An instance of ArrayReader 
    # @param {int} target an integer
    # @return {int} an integer
    def searchBigSortedArray(self, reader, target):
        # write your code here
        #corner case
        if reader is None or reader.get(0) == -1:
            return -1
        #preprocessing: find an upper bound
        index = 1
        while reader.get(index - 1) < target and reader.get(index - 1) != -1:
            index = index * 2
        start = 0
        end = index - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if reader.get(mid) < target and reader.get(mid) != -1:
                start = mid
            else:
                end = mid
        if reader.get(start) == target:
            return start
        elif reader.get(end) == target:
            return end
        return -1