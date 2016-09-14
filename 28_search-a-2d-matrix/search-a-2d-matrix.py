# coding:utf-8
'''
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Python
@Datetime: 16-05-15 20:44
'''

class Solution:
    """
    @param matrix, a list of lists of integers
    @param target, an integer
    @return a boolean, indicate whether matrix contains target
    """
    def searchMatrix(self, matrix, target):
        # write your code here
        if matrix is None or len(matrix) == 0 or matrix[0] is None or len(matrix[0]) == 0:
            return False
            
        start = 0
        end = len(matrix) * len(matrix[0]) - 1
        offset = len(matrix[0])
        
        while start + 1 < end:
            mid = start + (end - start) / 2
            if matrix[mid / offset][mid % offset] == target:
                return True
            elif matrix[mid / offset][mid % offset] < target:
                start = mid
            else:
                end = mid
        if matrix[start / offset][start % offset] == target:
            return True
        if matrix[end / offset][end % offset] == target:
            return True
        return False
