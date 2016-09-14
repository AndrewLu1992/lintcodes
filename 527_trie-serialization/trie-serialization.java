/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/trie-serialization
@Language: Java
@Datetime: 16-09-01 20:39
*/

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        // Write your code here
        //DFS to serialize the trie tree.
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        Iterator it = root.children.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, TrieNode> entry = (Map.Entry)it.next();
            sb.append(entry.getKey());
            sb.append(serialize(entry.getValue()));
        }
        sb.append("-");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        // Write your code here
        //Deserialize with DFS using stack.
        if (data == null || data.length() == 0) {
            return null;
        }
        
        TrieNode root = new TrieNode();
        TrieNode curr = root;
        Stack<TrieNode> stack = new Stack<>();
        
        for(char c : data.toCharArray()) {
            if (c == '|') {
                stack.push(curr);
            } else if (c == '-') {
                stack.pop();
            } else {
                curr = new TrieNode();
                stack.peek().children.put(c, curr); 
            }
        }
        
        return root;
    }
}
