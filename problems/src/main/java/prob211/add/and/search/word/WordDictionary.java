package prob211.add.and.search.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 1/18/2018.
 * Modified by yanya04 on 5/5/2018.
 */
public class WordDictionary {

    private Map<Integer, List<String>> map;


    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();
        map.putIfAbsent(len, new ArrayList<>());
        map.get(len).add(word);

    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int len = word.length();

        List<String> ws = map.get(len);
        if(ws == null) return false;

        for(String w: ws){
            if(isSame(w, word)){
                return true;
            }
        }
        return false;
    }

    //  match ..a with aba
    private boolean isSame(String word, String pattern){
        for(int i = 0; i < word.length(); i ++){
            if(word.charAt(i) != pattern.charAt(i) && pattern.charAt(i) != '.')
                return false;
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */