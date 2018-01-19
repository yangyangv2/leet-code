package prob332.reconstruct.itinerary;

import java.util.*;

public class Solution {

    /*
    WordDictionary:

    DFS traverse
    backward print

    */

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(String[] ticket: tickets){
            graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<String>()).add(ticket[1]);
        }
        List<String> list = new LinkedList<>();
        traverse("JFK", graph, list);
        return list;
    }

    private void traverse(String from, Map<String, PriorityQueue<String>> graph, List<String> list){
        PriorityQueue<String> queue = graph.get(from);
        if(queue != null){
            while(!queue.isEmpty()){
                traverse(queue.poll(), graph, list);
            }
        }
        list.add(0, from);
    }
}
