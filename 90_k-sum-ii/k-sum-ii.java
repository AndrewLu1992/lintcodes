/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Java
@Datetime: 16-08-04 11:36
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    //DFS using stack.
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result =
            new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        dfs(A, k, target, path, result, 0);
        return result;
    }
    
    //DFS traversal.
    private void dfs(int[] A, int k, int target, ArrayList<Integer> path,
        ArrayList<ArrayList<Integer>> result, int index) {
            if (k == 0 && target == 0) {
                result.add(new ArrayList<Integer>(path));
                return;
            }
            if (k == 0) {
                return;
            }
            for (int i = index; i < A.length; i++) {
                path.add(A[i]);
                dfs(A, k - 1, target - A[i], path, result, i + 1);
                path.remove(path.size() - 1);
            }
        }
}