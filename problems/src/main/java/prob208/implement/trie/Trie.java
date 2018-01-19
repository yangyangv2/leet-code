package prob208.implement.trie;

/**
 * Created by yanya04 on 1/18/2018.
 */
public class Trie {


    private static class TrieNode{
        TrieNode[] children;
        String word;
    }


    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i ++){
            int index = word.charAt(i) - 'a';
            if(node.children == null){
                node.children = new TrieNode[26];
            }
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, root, 0, false);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(prefix, root, 0, true);
    }


    private boolean search(String word, TrieNode node, int start, boolean startsWith){
        if(node == null) return false;
        if(start == word.length()){
            // startsWith
            if(startsWith) return true;

            // search
            if(node.word != null) return true;
            return false;
        }

        int index = word.charAt(start) - 'a';

        if(node.children == null || node.children[index] == null)
            return false;

        return search(word, node.children[index], start + 1, startsWith);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
