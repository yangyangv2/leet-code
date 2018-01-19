package prob212.word.search.ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yanya04 on 1/18/2018.
 */
public class Solution {
    /*
        DFS, start from any point to see if it meets a word
        Use Trie to speed up.
    */
    public List<String> findWords(char[][] board, String[] words) {


        List<String> result = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0)
            return result;

        Trie trie = Trie.build(words);

        int m = board.length, n = board[0].length;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < m; i ++)
            for(int j = 0; j < n; j ++)
                dfs(board, i, j, set, trie, trie.root);
        return new ArrayList<>(set);
    }




    private void dfs(char[][] board, int i, int j, Set<String> set, Trie trie, Node node){
        int m = board.length, n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#')
            return;
        char c = board[i][j];
        Node next = trie.next(c - 'a', node);
        if(next != null){
            if(next.word != null){
                set.add(next.word);
            }
            board[i][j] = '#';
            dfs(board, i + 1, j, set, trie, next);
            dfs(board, i, j + 1, set, trie, next);
            dfs(board, i - 1, j, set, trie, next);
            dfs(board, i, j - 1, set, trie, next);
            board[i][j] = c;
        }
    }

    private static class Node{
        Node[] children;
        String word;
    }

    private static class Trie {

        Node root;
        Trie(){
            root = new Node();
        }

        private void insert(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i ++){
                int index = word.charAt(i) - 'a';
                if(node.children == null)
                    node.children = new Node[26];
                if(node.children[index] == null)
                    node.children[index] = new Node();
                node = node.children[index];
            }
            node.word = word;
        }

        Node next(int index, Node node){
            if(node == null || node.children == null)
                return null;
            return node.children[index];
        }

        static Trie build(String[] words){
            Trie trie = new Trie();

            for(String word: words){
                trie.insert(word);
            }
            return trie;
        }
    }

}
