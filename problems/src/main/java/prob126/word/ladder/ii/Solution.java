package prob126.word.ladder.ii;

import java.util.*;

/**
 * Created by yanya04 on 1/10/2018.
 */
public class Solution {

    /*
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log","cog"]

      [
        ["hit","hot","dot","dog","cog"],
        ["hit","hot","lot","log","cog"]
      ]

        BSD to get the node-parents map
        DFS to find the shortest path


    */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        Set<String> unvisited = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, List<String>> map = new HashMap<>();

        int visits = 1;
        int nexts = 0;

        while(!queue.isEmpty()){
            String word = queue.poll();
            visits --;
            boolean found = false;
            char[] chars = word.toCharArray();
            for(int i = 0; i < word.length(); i ++){
                char backup = chars[i];
                for(char j = 'a'; j <= 'z'; j ++ ){
                    chars[i] = j;
                    String newWord = new String(chars);
                    if(unvisited.contains(newWord)){
                        if(visited.add(newWord)){
                            nexts ++;
                            queue.offer(newWord);
                        }
                        List<String> list = map.get(newWord);
                        if(list == null){
                            list = new ArrayList<String>();
                            map.putIfAbsent(newWord, list);
                        }
                        list.add(word);

                        if(newWord.equals(endWord)){
                            found = true;
                        }
                    }
                }
                chars[i] = backup;
            }
            if(visits == 0){    // when visits is 0, it means all the nodes on the current level has been visited
                if(found) break;
                visits = nexts;
                nexts = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }

        List<String> list = new ArrayList<>();
        list.add(endWord);
        dfs(map, list, beginWord, endWord, result);
        return result;
    }

    private void dfs(Map<String, List<String>> map, List<String> list, String beginWord, String thisWord, List<List<String>> result){
        if(thisWord.equals(beginWord)){
            result.add(new ArrayList<String>( list));
            return;
        }
        if(map.containsKey(thisWord)){
            for(String word: map.get(thisWord)){
                list.add(0, word);
                dfs(map, list, beginWord, word, result);
                list.remove(0);
            }
        }
    }
}