package prob127.word.ladder;

import java.util.*;

/**
 * Created by yanya04 on 1/9/2018.
 */
public class Solution {
    /*
        beginWord = "hit"
        endWord = "cog"
        wordList = ["hot","dot","dog","lot","log","cog"]

        hit->hot->dot->dog->cog
                ->lot->log

        BFS

    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // word set
        Set<String> set = new HashSet<>(wordList);
        // BFS queue
        Queue<String> queue = new LinkedList<>();
        // word and level
        Map<String, Integer> map = new HashMap<>();

        queue.offer(beginWord);
        set.remove(beginWord);
        map.put(beginWord, 1);

        while(!queue.isEmpty()){

            String word = queue.poll();
            int level = map.get(word);

            char[] chars = word.toCharArray();
            for(int i = 0; i < chars.length; i ++){
                char tmp = chars[i];
                for(char j = 'a'; j <= 'z'; j ++){
                    chars[i] = j;
                    String newWord = new String(chars);
                    if(set.contains(newWord)){
                        if(newWord.equals(endWord)){
                            return level + 1;
                        }
                        map.put(newWord, level + 1);
                        set.remove(newWord);
                        queue.offer(newWord);
                    }
                    chars[i] = tmp;
                }
            }
        }

        return 0;
    }
}
