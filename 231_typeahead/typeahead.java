/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/typeahead
@Language: Java
@Datetime: 16-09-02 21:11
*/

public class Typeahead {
    // @param dict A dictionary of words dict
    /**
    *Idea: Use hashMap to achieve O(1) search.
    * Map all possible subtrings of strings in the dictionary to lists 
    * of strings that contains the substring in the dictionary.
    */
    private HashMap<String, List<String>> hash;
    
    public Typeahead(Set<String> dict) {
        // do initialize if necessary
        hash = new HashMap<String, List<String>>();
        for (String s : dict) {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                   String substring = s.substring(i, j);
                   if (!hash.containsKey(substring)) {
                       hash.put(substring, new ArrayList<String>());
                       hash.get(substring).add(s);
                   } else {
                       List<String> index = hash.get(substring);
                       if (!index.get(index.size() - 1).equals(s)) {
                           index.add(s);
                       }
                   }
                }
            }
        }
    }

    // @param str: a string
    // @return a list of words
    public List<String> search(String str) {
        // Write your code here
        if (!hash.containsKey(str)) {
            return new ArrayList<>();
        } else {
            return hash.get(str);
        }
    }
}