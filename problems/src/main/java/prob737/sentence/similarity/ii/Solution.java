package prob737.sentence.similarity.ii;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    class UF{
        Map<String, String> parents;
        UF(){
            parents = new HashMap<>();
        }

        String find(String word){

            String parent = parents.get(word);
            if(parent == null){
                parents.put(word, word);
                return word;
            }

            while(!word.equals(parent)){
                parents.put(word, parent);
                word = parent;
                parent = parents.get(word);
            }
            return word;
        }

        void union(String[] pair){
            String str1 = find(pair[0]);
            String str2 = find(pair[1]);
            if(!str1.equals(str2)){
                parents.put(str1, str2);
            }
        }

    }

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        UF uf = new UF();

        for(String[] pair: pairs){
            uf.union(pair);
        }

        if(words1.length != words2.length) return false;

        for(int i = 0; i < words1.length; i ++){
            if(!uf.find(words1[i]).equals(uf.find(words2[i])))
                return false;
        }

        return true;
    }
}