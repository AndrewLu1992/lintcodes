/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/standard-bloom-filter
@Language: Java
@Datetime: 16-09-08 17:38
*/

public class StandardBloomFilter {
    
    private HashSet<String> filter;

    public StandardBloomFilter(int k) {
        // initialize your data structure here
        filter = new HashSet<String>(k);
    }

    public void add(String word) {
        // Write your code here
        filter.add(word);
    }

    public boolean contains(String word) {
        // Write your code here
        return filter.contains(word);
    }
}