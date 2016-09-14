/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 16-07-01 03:59
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    //Recursion method.
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result =
            new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(nums, list, result);
        return result;
    }
    private void dfs(ArrayList<Integer> nums, 
        ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
            if (list.size() == nums.size()) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
            for (int i = 0; i < nums.size(); i++) {
                if (list.contains(nums.get(i))) {
                    continue;
                }
                list.add(nums.get(i));
                dfs(nums, list, result);
                //Attention to the tail processing.
                list.remove(list.size() - 1);
            }
        }
}
