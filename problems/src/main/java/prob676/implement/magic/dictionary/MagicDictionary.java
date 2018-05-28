package prob676.implement.magic.dictionary;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 5/24/2018.
 */
public class MagicDictionary {

    private Set<String> set;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        String word = null;
        for(int i = 0; i < dict.length; i ++){
            for(int j = 0; j < dict[i].length(); j ++){
                for(int k = 0; k <= 26; k ++){

                    if((char) (k + 'a') == dict[i].charAt(j))
                        continue;

                    if(j == 0)
                        word = (char)(k + 'a') + dict[i].substring(1);
                    else
                        word = dict[i].substring(0, j) + (char)(k + 'a') + dict[i].substring(j + 1, dict[i].length());
                    set.add(word);
                }
            }
        }

    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return set.contains(word);
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
