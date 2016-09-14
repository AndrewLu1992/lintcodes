/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/n-queens-ii
@Language: Java
@Datetime: 16-07-02 04:34
*/

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    //Speial conterexample: Not using DP but using DFS.
    private int sum = 0;
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            if (cols.get(i) == col) {
                return false;
            }
            if (row - i == Math.abs(col - cols.get(i))) {
                return false;
            }
        }
        return true;
    }
    private void placeQueens(int n, ArrayList<Integer> cols) {
        if (cols.size() == n) {
            sum++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(cols, i)) {
                cols.add(i);
                placeQueens(n, cols);
                cols.remove(cols.size() - 1);
            }
        }
    }
    public int totalNQueens(int n) {
        //write your code here
        if (n <= 0) {
            return 0;
        }
        ArrayList<Integer> cols = new ArrayList<>();
        placeQueens(n, cols);
        return sum;
    }
};

