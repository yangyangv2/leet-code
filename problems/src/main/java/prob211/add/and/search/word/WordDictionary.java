package prob211.add.and.search.word;

/**
 * Created by yanya04 on 1/18/2018.
 */
public class WordDictionary
{
    private static class TrieNode{
        TrieNode[] children;
        String word = null;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);
            int index = c - 'a';
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

    private boolean search(String word, int start, TrieNode node){
        if(node == null){
            return false;
        }

        if(start == word.length()){
            if(node.word != null)
                return true;
            else
                return false;
        }

        char c = word.charAt(start);
        if(c == '.'){
            if(node.children == null){
                return false;
            }
            for(TrieNode n: node.children){
                if(n != null && search(word, start + 1, n)){
                    return true;
                }
            }
            return false;

        } else {

            int index = c - 'a';
            if(node.children != null){
                return search(word, start + 1, node.children[index]);
            } else {
                return false;
            }
        }
    }


    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
