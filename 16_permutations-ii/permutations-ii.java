/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 16-07-01 05:54
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result =
            new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }
        //The nums needed to be sorted.
        Collections.sort(nums);
        //This is to detect if dfs has reached to the end
        ArrayList<Integer> list = new ArrayList<>();
        //This is used to remove duplications.
        boolean[] visited = new boolean[nums.size()];
        //dfs process
        dfs(nums, list, visited, result);
        return result;
    }
    
    private void dfs(ArrayList<Integer> nums, ArrayList<Integer> list
        , boolean[] visited, ArrayList<ArrayList<Integer>> result) {
            //Recursion base case.
            if (list.size() == nums.size()) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
            for (int i = 0; i < nums.size(); i++) {
                if (visited[i] || (i != 0 && 
                    nums.get(i) == nums.get(i - 1) && !visited[i - 1])) {
                    continue;
                }
                list.add(nums.get(i));
                visited[i] = true;
                dfs(nums, list, visited, result);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
}
