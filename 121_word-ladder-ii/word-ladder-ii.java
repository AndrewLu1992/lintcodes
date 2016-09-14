/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 16-07-04 12:40
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    private String replace(String word, int i, char c) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
    
    private ArrayList<String> findNext(String word, Set<String> dict) {
        ArrayList<String> words = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
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
    //DFS.
    private void dfs(String start, String end,
        HashMap<String, List<String>> map, HashMap<String, Integer> distance,
        List<String> path, ArrayList<List<String>> result) {
            path.add(end);
            if (end.equals(start)) {
                //Reverse the collections.
                Collections.reverse(path);
                result.add(new ArrayList<String>(path));
                Collections.reverse(path);
            } else {
                for (String ancestor : map.get(end)) {
                    if (distance.containsKey(ancestor) &&
                        distance.get(end) == distance.get(ancestor) + 1) {
                            dfs(start, ancestor, map, distance, path, result);
                        }
                }
            }
            path.remove(path.size() - 1);
        }
    //BFS
    private void bfs(String start, String end, Set<String> dict,
        HashMap<String, List<String>> map, HashMap<String, Integer> distance) {
            Queue<String> q = new LinkedList<>();
            q.offer(start);
            distance.put(start, 0);
            for(String w : dict) {
                map.put(w, new ArrayList<String>());
            }
            while (!q.isEmpty()) {
                String crt = q.poll();
                ArrayList<String> nextList = findNext(crt, dict);
                for (String next : nextList) {
                    map.get(next).add(crt);
                    if (!distance.containsKey(next)) {
                        q.offer(next);
                        distance.put(next, distance.get(crt) + 1);
                    } 
                }
            }
        }
        
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        //Path list is used in dfs to store solutions.
        List<String> path = new ArrayList<>();
        //Map is used to store all instant ancestors of each word.
        HashMap<String, List<String>> map = new HashMap<>();
        //Distance is used to 
        //store distances to the start string for all words.
        HashMap<String, Integer> distance = new HashMap<>();
        if (start == null || start.length() == 0 ||
            end == null || end.length() == 0) {
            return result;
        }
        if (start.equals(end)) {
            path.add(start);
            result.add(path);
            return result;
        }
        dict.add(end);
        dict.add(start);
        //Firstly we use bfs to calculate distances to the start
        //and all ancestor words of all words.
        bfs(start, end, dict, map, distance);
        //Secondly, we search from the end word upto the closest
        //start word. Each time goes up 1 unit distance.
        dfs(start, end, map, distance, path, result);
        return result;
    }
}