/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Java
@Datetime: 16-08-23 19:22
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    boolean isString;
    String s;
    HashMap<Character, TrieNode> subtrees;
    
    public TrieNode() {
        isString = false;
        s = "";
        subtrees = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            if (!now.subtrees.containsKey(word.charAt(i))) {
                now.subtrees.put(word.charAt(i), new TrieNode());
            }
            now = now.subtrees.get(word.charAt(i));
        }
        if (!now.isString) {
            now.isString = true;
            now.s = word;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            if (!now.subtrees.containsKey(word.charAt(i))) {
                return false;
            }
            now = now.subtrees.get(word.charAt(i));
        }
        //This step is necessary to see if the node is leaf node.
        //if not, then word is only a prefix of some words in trie.
        if (now.isString) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode now = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!now.subtrees.containsKey(prefix.charAt(i))) {
                return false;
            }
            now = now.subtrees.get(prefix.charAt(i));
        }
        return true;
    }
}