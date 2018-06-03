package prob839.similar.string.groups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  Created by yanya04 on 6/2/2018.
 */
public class Solution {
    /*
        A is similair to B
        B is similiar to C
        then all A, B, C are in the same group
    */
    public int numSimilarGroups(String[] A) {

        UF uf = new UF(A);
        Set<String> dup = new HashSet<>();

        for(int i = 0; i < A.length; i ++){
            for(int j = 0; j < i; j ++){
                if(dup.contains(A[i])) continue;
                if(similiar(A[i], A[j])){
                    uf.union(A[i], A[j]);
                } else if(A[i].equals(A[j])){
                    dup.add(A[i]);
                }
            }
        }

        int dupcnt = 0;
        for(String str: A){
            if(dup.contains(str))
                dupcnt ++;
        }
        return uf.count - (dupcnt - dup.size());
    }


    class UF{

        Map<String, String> parents;
        int count = 0;

        UF(String[] A){
            parents = new HashMap<>(A.length * 2);
            for(String str: A){
                parents.put(str, str);
                count ++;
            }
        }
        String find(String word){
            while(! word.equals(parents.get(word))){
                parents.put(word, parents.get(parents.get(word)));
                word = parents.get(word);
            }
            return word;
        }

        boolean union(String word1, String word2){
            word1 = find(word1);
            word2 = find(word2);
            if(word1.equals(word2)){
                return false;
            } else {
                if(word1.compareTo(word2) < 0){
                    parents.put(word2, word1);
                } else {
                    parents.put(word1, word2);
                }
                count --;
                return true;
            }
        }
    }



    private boolean similiar(String a, String b){
        if(a.length() != b.length()) return false;
        if(a.length() < 2) return false;

        int diff = 0, ver = 0;
        for(int i = 0; i < a.length(); i ++){
            if(a.charAt(i) != b.charAt(i)){
                diff ++;
                ver = ver ^ a.charAt(i);
                ver = ver ^ b.charAt(i);
            }
        }
        return diff == 2 && ver == 0;
    }
}