package prob444.sequence.reconstruction;

import java.util.*;

/**
 *  Created by yanya04 5/13/2018.
 */
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        if(org == null || org.length == 0 || seqs == null || seqs.isEmpty())
            return false;

        Map<Integer, Set<Integer>> indegree = new HashMap<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> enableSet = null;
        Set<Integer> indegreeSet = null;

        for(List<Integer> seq: seqs){
            for(int i = 1; i < seq.size(); i ++){

                // topology sort cannot handle duplicate edges!

                enableSet = graph.get(seq.get(i - 1));
                if(enableSet == null){
                    enableSet = new HashSet<>();
                    graph.put(seq.get(i - 1), enableSet);
                }
                enableSet.add(seq.get(i));

                indegreeSet = indegree.get(seq.get(i));
                if(indegreeSet == null){
                    indegreeSet = new HashSet<>();
                    indegree.put(seq.get(i), indegreeSet);
                }
                indegreeSet.add(seq.get(i - 1));
            }
            // add the first element (candidate entry node) into the map
            if(!seq.isEmpty() && !indegree.containsKey(seq.get(0))){
                indegree.put(seq.get(0), new HashSet<>());
            }
        }

        // need to get entry from the indegree set
        // it is possible to have [1], {[],[]} as input
        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Set<Integer>> entry: indegree.entrySet()){
            if(entry.getValue().isEmpty()){
                queue.offer(entry.getKey());
            }
        }

        int index = 0, cur = 0;
        while(!queue.isEmpty()){
            if(queue.size() > 1) return false;
            cur = queue.poll();
            if(index == org.length || cur != org[index]) return false;
            index ++;
            enableSet = graph.get(cur);
            if(enableSet != null){
                for(Integer enabled: enableSet){
                    indegreeSet = indegree.get(enabled);
                    indegreeSet.remove(cur);
                    if(indegreeSet.isEmpty()){
                        queue.offer(enabled);
                    }
                }
            }
        }
        return index == org.length && indegree.size() == org.length;
    }
}