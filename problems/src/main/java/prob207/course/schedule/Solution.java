package prob207.course.schedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);

        for(int i = 0; i < numCourses; i ++){
            graph.add(new ArrayList<Integer>());
        }

        // build up the prerequisite map and indegree counter
        for(int[] prerequisite: prerequisites){

            // if do prerequisite[1], it will enable prerequisite[0]
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]] ++;
        }

        Queue<Integer> process = new ArrayDeque<>();

        // put courses with no prerequisite into process queue
        for(int i = 0; i < numCourses; i ++){
            if(inDegree[i] == 0){
                process.offer(i);
            }
        }

        int processed = 0;

        // start BFS
        while(!process.isEmpty()){
            int course = process.poll();
            processed ++;
            for(Integer enabled: graph.get(course)){
                inDegree[enabled] --;
                if(inDegree[enabled] == 0){
                    process.offer(enabled);
                }
            }
        }

        // when all the courses are processed
        return processed == numCourses;

    }
}