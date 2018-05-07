package prob212.word.search.ii;

import java.util.*;

/**
 * Created by yanya04 on 1/18/2018.
 * Modified by yanya04 on 5/5/2018.
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
            int start = 0;
            TrieNode cur = root;
            char c = ' ';
            while(start < word.length()){
                c = word.charAt(start);
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
                if(start == word.length() - 1){
                    cur.word = word;
                }
                start ++;
            }
        }
    }

    private void dfs(char[][] board, int i, int j, TrieNode trie, Set<String> set){
        int m = board.length, n = board[0].length;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return;

        char c = board[i][j];
        TrieNode next = trie.children[c - 'a'];
        if(next == null) return;

        if(next.word != null) set.add(next.word);

        board[i][j] = '#';

        dfs(board, i + 1, j, next, set);
        dfs(board, i - 1, j, next, set);
        dfs(board, i, j + 1, next, set);
        dfs(board, i, j - 1, next, set);

        board[i][j] = c;
    }


    public List<String> findWords(char[][] board, String[] words) {

        if(board == null || board.length == 0 || board[0].length == 0 ||
                words == null || words.length == 0)
            return Collections.emptyList();

        Trie trie = new Trie();
        trie.build(words);

        Set<String> set = new HashSet<>();
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                dfs(board, i, j, trie.root, set);
            }
        }

        return new ArrayList<String>(set);
    }
}