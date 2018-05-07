package prob211.add.and.search.word;

/**
 * Created by yanya04 on 1/18/2018.
 * Modified by yanya04 on 5/5/2018.
 */
class WordDictionary {

    class TrieNode {
        char c;
        boolean end;
        TrieNode[] children;
        TrieNode(char c){
            this.c = c;
            this.children = new TrieNode[26];
        }
    }
    class Trie {
        TrieNode root;

        Trie(){
            root = new TrieNode(' ');
        }

        void insert(String word){
            int i = 0; char c = ' ';
            TrieNode cur = root;
            while(i < word.length()){
                c = word.charAt(i);
                if(cur.children[c - 'a'] == null){
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
                if(i == word.length() - 1){
                    cur.end = true;
                }
                i ++;
            }
        }

        boolean search(String word, int start, TrieNode node){

            if(node == null) return false;

            if(start == word.length()) return node.end;

            char c = word.charAt(start);

            if(c == '.'){
                for(TrieNode child: node.children){
                    if(search(word, start + 1, child))
                        return true;
                }
                return false;
            } else {
                return search(word, start + 1, node.children[c - 'a']);
            }
        }
    }

    private Trie trie;
    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word, 0, trie.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */