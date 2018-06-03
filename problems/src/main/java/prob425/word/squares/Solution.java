package prob425.word.squares;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by yanya04 on 5/27/2018.
 *  Modified by yanya04 on 6/2/2018.
 */
public class Solution {

    /*

        backtrack, pick anyword to start with, use try to speed up.

        baba
        abat
        baba
        atal
    */

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();

        String word = null;
        List<String> list = new ArrayList<>();

        Trie trie = new Trie(words);

        for(int i = 0; i < words.length; i ++){
            list.add(words[i]);
            search(res, list, words[i].length(), trie);
            list.remove(list.size() - 1);
        }

        return res;
    }

    private void search(List<List<String>> res, List<String> list, int len, Trie trie){
        if(list.size() == len){
            res.add(new ArrayList<>(list));
            return ;
        }

        int index = list.size();
        StringBuilder prefix = new StringBuilder();
        String temp = null;
        for(int i = 0; i < list.size(); i ++){
            temp = list.get(i);
            if(temp.length() > index){
                prefix.append(list.get(i).charAt(index));
            }
        }

        // find a list of words starts wtih prefix

        for(String word: trie.search(prefix.toString())){
            if(word.length() > len) continue;
            list.add(word);
            search(res, list, len, trie);
            list.remove(list.size() - 1);
        }
    }


    private class Trie{
        private class TrieNode{
            TrieNode[] children = new TrieNode[26];
            List<String> wordlist = new ArrayList<>();
        }

        TrieNode root;

        Trie(String[] words){
            root = new TrieNode();
            for(String word: words){
                insert(word);
            }
        }

        private void insert(String word){
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i ++){
                int index = word.charAt(i) - 'a';
                if(cur.children[index] == null){
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
                cur.wordlist.add(word);
            }
        }

        List<String> search(String prefix){
            List<String> res = new ArrayList<>();
            TrieNode cur = root;

            for(int i = 0; i < prefix.length(); i ++){
                int index = prefix.charAt(i) - 'a';
                if(cur.children[index] == null)
                    return res;
                cur = cur.children[index];
            }

            return cur.wordlist;
        }

    }

}