package prob269.alien.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

/**
 * Created by yanya04 on 1/24/2018.
 */
public class Solution {

    /*
        1.  build a direcinal graph from words
            each character is a node
            the relation between two character is the edge
            the direction is from lower alphabeta to higher
        2.  use topology sort, which can give the right order from lowerest character to the highest

    */
    public String alienOrder(String[] words) {

        // build a graph

        HashMap<Character, Set<Character>> graph = new HashMap<>();
        int[] degree = new int[26]; // only 26 possible characters

        // compare horizontally

        for(String word: words){
            for(char c: word.toCharArray()){
                if(degree[c - 'a'] == 0){
                    degree[c - 'a'] = 1;
                }
            }
        }

        for(int i = 0; i < words.length - 1; i ++){
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for(int j = 0; j < len; j ++){
                if(cur.charAt(j) != next.charAt(j)){
                    // cur[j] is lower than next[j]

                    if(!graph.containsKey(cur.charAt(j))){
                        graph.put(cur.charAt(j), new HashSet<Character>());
                    }

                    if(graph.get(cur.charAt(j)).add(next.charAt(j))){
                        degree[next.charAt(j) - 'a'] ++;
                    }
                    break;
                }
            }
        }

        // topology sort

        return topologySort(graph, degree);
    }

    private String topologySort(HashMap<Character, Set<Character>> graph, int[] degree){

        StringBuilder sb = new StringBuilder();
        int count = 0;

        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < degree.length; i ++){
            if(degree[i] == 0) continue;
            count ++;
            if(degree[i] == 1) {
                queue.offer((char) (i + 'a'));
            }
        }


        while(!queue.isEmpty()){

            char node = queue.poll();
            sb.append(node);
            if(graph.containsKey(node)){
                for(char child: graph.get(node)){
                    if(--degree[child - 'a'] == 1){
                        queue.offer(child);
                    }
                }
            }
        }

        if(sb.length() != count) return "";
        else return sb.toString();

    }
}