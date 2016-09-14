/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 16-07-03 07:33
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    //There is no replace method in string class
    private String replace(String word, int index, char c) {
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    /**Replace one char in the word.
     * Return a word contained in the dict.
    */
    private ArrayList<String> findNext(String word, Set<String> dict) {
        ArrayList<String> words = new ArrayList<>(); 
        for (char c = 'a'; c<='z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String next = replace(word, i, c);
                if (dict.contains(next)) {
                   words.add(next); 
                }
            }
        }
        return words;
    }
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start == null || start.length() == 0) {
            return 0;
        }
        // If start == end. Return 1.
        if (start.equals(end)) {
            return 1;
        }
        int step = 1;
        Queue<String> queue = new LinkedList<>();
        //Record nodes have already been discovered.
        HashSet<String> path = new HashSet<>();
        queue.offer(start);
        path.add(start);
        //If end string is not added into dict. It wont be discovered 
        //Because findNext method will only return string in dict.
        dict.add(end);
        while (!queue.isEmpty()) {
            //Remember the breath of current search tree.
            int size = queue.size();
            step++;
            //Firstly, we need to iterate though the current
            //nodes in depth step.
            for (int i = 0; i < size; i++) {
                String top = queue.poll();
                //For each node, add next words into the queue
                for(String word : findNext(top, dict)) {
                    if (word.equals(end)) {
                        return step;
                    }
                    if (path.contains(word)) {
                        continue;
                    }
                    queue.offer(word);
                    path.add(word);
                }
            }
        }
        return 0;
    }
}