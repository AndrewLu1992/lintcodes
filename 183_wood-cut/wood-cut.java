/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 16-05-17 20:38
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        //Find the maximum value
        if (sum(L) < k) return 0;
        int max = 0;
        for(int i=0; i<L.length; i++){
            if (max < L[i]) max = L[i];
        }
        //binary search
        int start = 1, end = max;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (count(L, mid) >= k){
                start = mid;
            }else{
                end = mid;
            }
        }
        if (count(L, end) >= k){
            return end;
        }
        return start;
    }
    
    private long sum(int[] L){
        long result = 0;
        for (int i=0; i<L.length; i++){
            result += L[i];
        }
        return result;
    }
    
    private int count(int[] L, int wood){
        int sum = 0;
        for(int i=0; i<L.length; i++){
            sum += L[i] / wood;
        }
        return sum;
    }
}