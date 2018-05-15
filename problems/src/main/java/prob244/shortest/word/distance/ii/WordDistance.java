package prob244.shortest.word.distance.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 1/20/2018.
 * Modified by yanya04 on 5/14/2018.
 */
public class WordDistance {

    private HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i ++){
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        if(list1 == null || list2 == null) return -1;
        int i = 0, j = 0, shortest = Integer.MAX_VALUE;
        int pos1 = 0, pos2 = 0;
        while(i < list1.size() && j < list2.size()){
            pos1 = list1.get(i); pos2 = list2.get(j);
            if(pos1 < pos2) i ++;
            else j ++;
            shortest = Math.min(shortest, Math.abs(pos2 - pos1));
        }
        return shortest;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */