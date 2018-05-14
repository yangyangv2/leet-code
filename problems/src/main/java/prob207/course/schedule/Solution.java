package prob207.course.schedule;

import java.util.*;

/**
 *  Modified by yanya04 on 5/13/2018.
 */
public class Solution {

    /*
    2, [[1,0]]

    courses: 0, 1

    prerequisite: 1 -> 0


    2, [[1,0], [0,1]]
    courses: 0, 1
    prerequisite: 0 -> 1, 1 -> 0

    */


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int[] prerequisite: prerequisites){
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            indegree[course] ++;
            Set<Integer> enableSet = graph.get(prereq);
            if(enableSet == null){
                enableSet = new HashSet<Integer>();
                graph.put(prereq, enableSet);
            }
            enableSet.add(course);
        }


        // BFS
        Queue<Integer> queue = new LinkedList<>();
        int processed = 0;

        for(int i = 0; i < numCourses; i ++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            processed ++;
            Set<Integer> enableSet = graph.get(course);
            if(enableSet != null){
                for(Integer enable: enableSet){
                    indegree[enable] --;
                    if(indegree[enable] == 0){
                        queue.offer(enable);
                    }
                }
            }
        }

        return processed == numCourses;
    }
}