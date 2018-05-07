package prob208.implement.trie;

/**
 * Created by yanya04 on 1/18/2018.
 * Modified by yanya04 on 5/5/2018.
 */
public class Trie {

    class TrieNode{
        char c;
        boolean word;
        TrieNode[] children;
        TrieNode(char c){
            this.c = c;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null) return;

        int i = 0;
        char c = ' ';
        TrieNode cur = root;
        while(i < word.length()){
            c = word.charAt(i);
            if(cur.children == null){
                cur.children = new TrieNode[26];
            }
            if(cur.children[c - 'a'] == null){
                cur.children[c - 'a'] = new TrieNode(c);
            }

            if(i == word.length() - 1){
                cur.children[c - 'a'].word = true;
            } else {
                cur = cur.children[c - 'a'];
            }
            i ++;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        if(node == null) return false;
        return node.word;
    }

    private TrieNode find(String word){
        int i = 0;
        char c = ' ';
        TrieNode cur = root;
        while(i < word.length()){
            c = word.charAt(i);
            if(cur.children == null || cur.children[c - 'a'] == null)
                return null;

            cur = cur.children[c - 'a'];
            if(i == word.length() - 1){
                return cur;
            }
            i ++;
        }
        return null;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */