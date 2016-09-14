/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/inverted-index
@Language: Java
@Datetime: 16-09-01 18:25
*/

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        HashMap<String, List<Integer>> res = new HashMap<>();
        if (docs.size() < 1) {
            return res;
        }
        for (Document doc : docs) {
            int id = doc.id;
            String[] words = doc.content.trim().split(" +");
            for (String word : words) {
                if (!res.containsKey(word)) {
                    res.put(word, new ArrayList<Integer>());
                }
                if (!res.get(word).contains(id)) {
                    res.get(word).add(id);
                }
            }
        }
        return res;
    }
}