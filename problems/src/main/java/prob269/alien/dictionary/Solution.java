package prob269.alien.dictionary;

import java.util.*;

/**
 * Created by yanya04 on 1/24/2018.
 * Modifiec by yanya04 on 6/2/2018.
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

        Map<Character, Set<Character>> indegree = new HashMap<>(), graph = new HashMap<>();

        Set<Character> indegreeSet = null, charSet = new HashSet<>();

        for(int i = 0; i < words.length; i ++){
            // build up char set and init char map
            for(int j = 0; j < words[i].length(); j ++){
                char c = words[i].charAt(j);
                if(charSet.add(c)){
                    indegree.put(c, new HashSet<>());
                    graph.put(c, new HashSet<>());
                }
            }
        }


        for(int i = 1; i < words.length; i ++){
            char[] chars = getOrder(words[i - 1], words[i]);
            if(chars == null) continue;
            indegree.get(chars[1]).add(chars[0]);
            graph.get(chars[0]).add(chars[1]);
        }

        Queue<Character> queue = new LinkedList<>();
        for(Character c: charSet){
            if(indegree.get(c).isEmpty()){
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        Character c = null;
        int ind = 0;
        while(!queue.isEmpty()){
            c = queue.poll();
            sb.append(c);
            for(Character l: graph.get(c)){
                indegreeSet = indegree.get(l);
                indegreeSet.remove(c);
                if(indegreeSet.isEmpty()){
                    queue.offer(l);
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