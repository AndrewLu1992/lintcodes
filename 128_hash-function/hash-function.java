/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 16-06-26 04:10
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if (key == null || key.length == 0) {
            return 0;
        }
        long ans = 0;
        for (int i = 0; i < key.length; i++) {
            ans = (33 * ans + key[i]) % HASH_SIZE;
        }
        return (int)ans;
    }
};