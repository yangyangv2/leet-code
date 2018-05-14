package prob210.course.schedule.ii;

import java.util.*;

/**
 *  Modified by yanya04 on 5/13/2018.
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        Set<Integer> enableSet = null;
        for(int[] prereq: prerequisites){
            // course: [0], prereq: [1]
            enableSet = graph.get(prereq[1]);
            if(enableSet == null){
                enableSet = new HashSet<>();
                graph.put(prereq[1], enableSet);
            }
            enableSet.add(prereq[0]);
            indegree[prereq[0]] ++;
        }

        Queue<Integer> queue = new LinkedList<>();
        // find the entry points
        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] res = new int[numCourses];
        int course = 0, processed = 0;
        // BFS
        while(!queue.isEmpty()){
            course = queue.poll();
            res[processed ++] = course;
            enableSet = graph.get(course);
            if(enableSet != null){
                for(Integer enabled: enableSet){
                    indegree[enabled] --;
                    if(indegree[enabled] == 0)
                        queue.offer(enabled);
                }
            }
        }

        return processed == numCourses ? res : new int[0];
    }
}