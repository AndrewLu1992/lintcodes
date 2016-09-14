/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/add-and-search-word
@Language: Java
@Datetime: 16-08-23 20:34
*/

public class WordDictionary {
    //Implement using trie.
    private class TrieNode {
        boolean isString;
        HashMap<Character, TrieNode> subtrees;
        
        public TrieNode() {
            isString = false;
            subtrees = new HashMap<Character, TrieNode>();
        }
    }
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            if (!now.subtrees.containsKey(word.charAt(i))) {
                now.subtrees.put(word.charAt(i), new TrieNode());
            }
            now = now.subtrees.get(word.charAt(i));
        }
        if (!now.isString) {
           now.isString = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    
    //DFS
    private boolean dfs(String word, int index, TrieNode now) {
        // Write your code here
        if (index >= word.length()) {
            return now.isString;
        }
        
        char c = word.charAt(index);
        if (c == '.') {
            for (char i = 'a'; i <= 'z'; i++) {
                if (now.subtrees.containsKey(i)) {
                    //Cannot directly return the function value,
                    //which will terminate search once not able to find
                    //a match. We need to search over all possibile match.
                    //Once there is a match then terminate the loop.
                    if (dfs(word, index + 1, now.subtrees.get(i))) {
                        return true;
                    }
                }
            }
            return false;
        } else if (!now.subtrees.containsKey(c)) {
            return false;
        } else {
            return dfs(word, index + 1, now.subtrees.get(c));
        }
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");