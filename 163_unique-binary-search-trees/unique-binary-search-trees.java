/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees
@Language: Java
@Datetime: 16-08-14 02:26
*/

public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    /**
    * Find out recursion relation.
    * Attension to how many elements in the collection.
    * numTrees(n) = NumTrees(n-1) + NumTrees(1) * NumTrees(n - 2) + ... +
    * NumTrees(n - 2) * 1 + NumTrees(n - 1).
    **/
    public int numTrees(int n) {
        // write your code here
        if (n < 0) {
            return 0;
        }
        
        int[] f = new int[n + 1];
        if (n < 2) {
            return 1;
        }
        
        f[0] = 1;
        f[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - 1 - j];
            }
        }
        
        return f[n];
    }
}