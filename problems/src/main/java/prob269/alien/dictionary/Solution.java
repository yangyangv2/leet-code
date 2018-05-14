package prob269.alien.dictionary;

import java.util.*;

/**
 * Created by yanya04 on 1/24/2018.
 */
public class Solution {
    /*
        Input 1:
        [
          "z",
          "x"
        ]
        z -> x

        Input 2:
        [
          "wrt",
          "wrf",
          "er",
          "ett",
          "rftt"
        ]

        t -> f
        w -> e
        r -> t
        e -> r
    */
    public String alienOrder(String[] words) {

        if(words == null || words.length == 0) return "";

        Map<Character, Set<Character>> indegree = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();

        Set<Character> lowerSet = null;
        Set<Character> charSet = new HashSet<>();

        for(int i = 0; i < words.length; i ++){
            // build up char set
            for(int j = 0; j < words[i].length(); j ++){
                charSet.add(words[i].charAt(j));
            }
        }

        Set<Character> indegreeSet = null;

        for(int i = 1; i < words.length; i ++){
            char[] chars = getOrder(words[i - 1], words[i]);
            if(chars == null) continue;

            indegreeSet = indegree.get(chars[1]);
            if(indegreeSet == null){
                indegreeSet = new HashSet<>();
                indegree.put(chars[1], indegreeSet);
            }
            indegreeSet.add(chars[0]);

            //indegree.put(chars[1], indegree.getOrDefault(chars[1], 0) + 1);
            lowerSet = graph.get(chars[0]);
            if(lowerSet == null){
                lowerSet = new HashSet<>();
                graph.put(chars[0], lowerSet);
            }
            lowerSet.add(chars[1]);
        }

        Queue<Character> queue = new LinkedList<>();
        for(Character c: charSet){
            if(indegree.getOrDefault(c, new HashSet<>()).isEmpty()){
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        Character c = null;
        int ind = 0;
        while(!queue.isEmpty()){
            c = queue.poll();
            sb.append(c);
            lowerSet = graph.get(c);
            if(lowerSet != null){
                for(Character l: lowerSet){
                    indegreeSet = indegree.get(l);
                    indegreeSet.remove(c);
                    if(indegreeSet.isEmpty()){
                        queue.offer(l);
                    }
                }
            }
        }

        if(sb.length() == charSet.size()){
            return sb.toString();
        } else {
            return "";
        }
    }

    private char[] getOrder(String word1, String word2){

        int min = Math.min(word1.length(), word2.length());

        for(int i = 0; i < min; i ++){
            if(word1.charAt(i) == word2.charAt(i)) continue;
            return new char[]{word1.charAt(i), word2.charAt(i)};
        }
        /* skip this case.
        "abx"
        "ab"

        "abx"
        "ab"
        */
        return null;
    }

}