/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Java
@Datetime: 16-06-30 01:53
*/

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    private class Pair {
        String key;
        int value;
        public Pair(String word, int freq) {
            key = word;
            value = freq;
        }
    }
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null || words.length == 0 || k == 0 || k > words.length) {
            return new String[0];
        }
        HashMap<String, Integer> dict = new HashMap<>();
        // O(n).
        for (int i = 0; i < words.length; i++) {
            if (dict.containsKey(words[i])) {
                dict.put(words[i], dict.get(words[i]) + 1);
            } else {
                dict.put(words[i], 1);
            }
        }
        Comparator<Pair> pairCompare = new Comparator<Pair>() {
            public int compare(Pair left, Pair right) {
                if (left.value == right.value) {
                    // Very tricky!!
                    //You right compare left return natural order!
                    return right.key.compareTo(left.key);
                }
                return left.value - right.value;
            }
        };
        Queue<Pair> pq = new PriorityQueue<>(k, pairCompare);
        for (String word: dict.keySet()) {
            Pair top = pq.peek();
            Pair newPair = new Pair(word, dict.get(word));
            if (pq.size() < k) {
                pq.offer(newPair);
            } else if (pairCompare.compare(top, newPair) < 0){
               pq.poll();
               pq.offer(new Pair(word, dict.get(word)));
            }
        }
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            String item = pq.poll().key;
            result[k - i - 1] = item;
        }
        return result;
    }
}