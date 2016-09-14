/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/word-count-map-reduce
@Language: Java
@Datetime: 16-09-09 21:35
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class WordCount {

    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.trim().split(" ");
            for (String w : words) {
                output.collect(w, 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int count = 0;
            while (values.hasNext()) {
                count += values.next();
            }
            output.collect(key, count);
        }
    }
}
