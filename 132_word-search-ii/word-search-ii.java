/*
@Copyright:LintCode
@Author:   hanqiao
@Problem:  http://www.lintcode.com/problem/word-search-ii
@Language: Java
@Datetime: 16-08-23 01:42
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    //First, code up the data structure trie.
    private class TrieNode {
        String s;
        boolean isString;
        HashMap<Character, TrieNode> subtree;
        
        public TrieNode() {
            s = "";
            isString = false;
            subtree = new HashMap<Character, TrieNode>();
        }
    }
    
    private class Trie {
        TrieNode root;
        
        public Trie(TrieNode node) {
            root = node;
        }
        
        public void insert(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    now.subtree.put(s.charAt(i), new TrieNode());
                }
                now = now.subtree.get(s.charAt(i));
            }
            now.s = s;
            now.isString = true;
        }
        
        public boolean find(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    return false;
                }
                now = now.subtree.get(s.charAt(i));
            }
            return now.isString;
        }
    }
    //options that one step can go for.
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    //DFS starting at (row, col). Each time it goes up, down, left or right.
    private void dfs(char[][] board, int row, int col, TrieNode root,
        ArrayList<String> res) {
            //If word can be found at leaf node in trie
            if (root.isString) {
                if (!res.contains(root.s)) {
                    res.add(root.s);
                }
            }
            //if not found or out of bound or forming a loop
            if (row < 0 || row >= board.length || col < 0 ||
                col >= board[0].length || board[row][col] == '0') {
                    return;
                }
            //DFS starting from (row, col).
            if (root.subtree.containsKey(board[row][col])) {
                for (int i = 0; i < 4; i++) {
                    char now = board[row][col];
                    //To avoid repeating search
                    board[row][col] = '0';
                    dfs(board, row + dx[i], col + dy[i],
                        root.subtree.get(now), res);
                    board[row][col] = now;
                }
            }
        }
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> res = new ArrayList<>();
        if (board == null || board.length == 0
            || board[0] == null || board[0].length == 0) {
                return res;
            }
        //Construct a new Trie
        Trie tree = new Trie(new TrieNode());
        for (String s : words) {
            tree.insert(s);
        }
        //DFS.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, tree.root, res);
            }
        }
        return res;
    }
}