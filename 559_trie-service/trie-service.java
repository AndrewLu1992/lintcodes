/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/trie-service
@Language: Java
@Datetime: 16-08-24 16:28
*/

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public List<Integer> top10;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *         List<Integer> top10 = new ArrayList<Integer>();
 *     }
 * }
 */
public class TrieService {

    private TrieNode root = null;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and 
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        // Write your cod here
        if (word == null || word.equals("")) {
            return;
        }
        
        TrieNode now = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                now.children.put(c, new TrieNode());
            }
            now = now.children.get(c);
            //Constant step because we only at most have 10 elements in top10.
            if (now.top10.size() < 10) {
                now.top10.add(frequency);
                Collections.sort(now.top10);
                Collections.reverse(now.top10);
            }
        }
    }
 }