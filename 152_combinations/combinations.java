/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 16-08-20 04:29
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> solution = new ArrayList<>();
		dfs(n, k, solution, res, 1);
		return res;
    }
    
    private void dfs(int n, int k, ArrayList<Integer> solution,
        ArrayList<List<Integer>> res, int index) {
            if (k == 0) {
                res.add(new ArrayList<Integer>(solution));
            } else {
                for (int i = index; i <= n; i++) {
                    solution.add(i);
                    //Next index is i + 1 but not index + 1 !!!
                    //if i + 1 > n then return nothing. Thus avoid
                    // cases such as 1, 2, 4, 4.
                    dfs(n, k - 1, solution, res, i + 1);
                    solution.remove(solution.size() - 1);
                }
            }
        }
}