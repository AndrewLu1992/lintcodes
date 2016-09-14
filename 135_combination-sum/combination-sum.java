/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 16-07-03 02:05
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        List<Integer> solution = new ArrayList<>();
        //We firstly sort candidates. The Result also sorted.
        //Duplicate elements are posited next to the other.
        Arrays.sort(candidates);
        search(candidates, target, 0, solution, result);
        return result;
    }
    //We need additional index to cut off unnecessary subtree.
    private void search(int[] candidates, int target, int index,
        List<Integer> solution, ArrayList<List<Integer>> result) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(solution));
                return;
            } else if (target < 0) {
                return;
            } else {
                int prev = -1;
                for (int i = index; i < candidates.length; i++) {
                    if (prev != -1 && prev == candidates[i]) {
                        continue;
                    }
                    solution.add(candidates[i]);
                    search(candidates, target - candidates[i],
                        i, solution, result);
                    solution.remove(solution.size() - 1);
                    prev = candidates[i];
                }
            }
        }
}