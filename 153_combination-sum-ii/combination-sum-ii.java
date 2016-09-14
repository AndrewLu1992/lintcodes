/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 16-07-03 02:29
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return result;
        }
        List<Integer> solution = new ArrayList<>();
        Arrays.sort(num);
        search(num, target, solution, result, 0);
        return result;
    }
    private void search(int[] num, int target, List<Integer> solution,
        ArrayList<List<Integer>> result, int index) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(solution));
                return;
            } else if (target < 0) {
                //Because all numbers are positive integers.
                return;
            } else {
                int prev = -1;
                for (int i = index; i < num.length; i++) {
                    if (prev != -1 && prev == num[i]) {
                        continue;
                    }
                    solution.add(num[i]);
                    //Only difference: we pass in i + 1
                    search(num, target - num[i], solution, result, i + 1);
                    solution.remove(solution.size() - 1);
                    prev = num[i];
                }
            }
        }
}