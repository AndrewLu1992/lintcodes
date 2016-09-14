/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 16-08-10 03:20
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        //Collision pointer.
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0;
        int pointer = A.length - 1;
        //i could equal to pointer because the last element
        //should also be check if it is elem.
        while (i <= pointer) {
            if (A[i] == elem) {
                A[i] = A[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }
}
