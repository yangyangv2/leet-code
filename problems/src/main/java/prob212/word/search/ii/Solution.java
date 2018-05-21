package prob212.word.search.ii;

import java.util.*;

/**
 * Created by yanya04 on 1/18/2018.
 * Modified by yanya04 on 5/5/2018.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution {

    class TrieNode {
        char val;
        String word;
        TrieNode[] children;
        TrieNode(char val){
            this.val = val;
            this.children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;
        Trie(){
            root = new TrieNode(' ');
        }

        void build(String[] words){
            for(String word: words){
                insert(word);
            }
        }

        void insert(String word){

            TrieNode cur = root;
            char c = ' ';
            for(int i = 0; i < word.length(); i ++){
                c = word.charAt(i);
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
                if(i == word.length() - 1){
                    cur.word = word;
                }
            }
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        if(board == null || words == null || board.length == 0 || words.length == 0)
            return Collections.emptyList();
        int m = board.length, n = board[0].length;
        Set<String> dict = new HashSet<>(Arrays.asList(words));

        Trie trie = new Trie();
        trie.build(words);

        Set<String> set = new HashSet<>();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                dfs(board, i, j, dict, trie.root, set);
            }
        }
        return new ArrayList<String>(set);
    }

    private void dfs(char[][] board, int row, int col, Set<String> dict, TrieNode node, Set<String> set){
        int m = board.length, n = board[0].length;
        if(row < 0 || row == m || col < 0 || col == n || board[row][col] == '#')
            return;

        char c = board[row][col];
        TrieNode next = node.children[c - 'a'];
        if(next == null)
            return;

        if(next.word != null){
            set.add(next.word);
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, dict, next, set);
        dfs(board, row - 1, col, dict, next, set);
        dfs(board, row, col + 1, dict, next, set);
        dfs(board, row, col - 1, dict, next, set);

        board[row][col] = c;
    }
}