/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Java
@Datetime: 16-06-21 15:33
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    // O(nlogn) time. O(n) space.
    private class PrefixSum {
        int sum;
        int index;
        public PrefixSum(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res[0] = res[1] = 0;
            return res;
        }
        int len = nums.length;
        int prev = 0;
        PrefixSum[] sums = new PrefixSum[len + 1];
        sums[0] = new PrefixSum(0, 0);
        //Memorize the prefix sums with associated original indices
        for (int i = 1; i <= len; i++) {
            sums[i] = new PrefixSum(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        //Sort sums array.
        Arrays.sort(sums, new Comparator<PrefixSum>() {
            public int compare(PrefixSum a, PrefixSum b) {
                return a.sum - b.sum;
            }
        });
        //Look up the answer. Memorized search
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (sums[i].sum - sums[i - 1].sum < ans) {
                ans = sums[i].sum - sums[i - 1].sum;
                if (sums[i].index < sums[i - 1].index) {
                    res[0] = sums[i].index;
                    res[1] = sums[i - 1].index - 1;
                } else {
                    res[0] = sums[i - 1].index;
                    res[1] = sums[i].index - 1;
                }
            }
        }
        return res;
    }
}
