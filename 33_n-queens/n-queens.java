/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Java
@Datetime: 16-07-01 12:25
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    private ArrayList<String> drawChessboard(ArrayList<Integer> cols) {
        ArrayList<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            String row = "";
            for (int j = 0; j < cols.size(); j++) {
                if (j == cols.get(i)) {
                    row += "Q";
                } else {
                    row += ".";
                }
            }
            chessboard.add(row);
        }
        return chessboard;
    }
    
    private boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();
        for (int i = 0; i < row; i++) {
            //Same Column
            if (cols.get(i) == col) {
                return false;
            }
            //Left-top to right-bottom
            if (i - cols.get(i) == row - col) {
                return false;
            }
            //Right-top to left-bottom
            if (i + cols.get(i) == row + col) {
                return false;
            }
        }
        return true;
    }
    private void search(int n, ArrayList<Integer> cols,
        ArrayList<ArrayList<String>> result) {
            if (cols.size() == n) {
               result.add(drawChessboard(cols));
               return;
            }
            for (int col = 0; col < n; col++) {
                if (!isValid(cols, col)) {
                    continue;
                }
                cols.add(col);
                search(n, cols, result);
                cols.remove(cols.size() - 1);
            }
        }
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> result =
            new ArrayList<ArrayList<String>>();
        if (n <= 0) {
            return result;
        }
        search(n, new ArrayList<Integer>(), result);
        return result;
    }
};