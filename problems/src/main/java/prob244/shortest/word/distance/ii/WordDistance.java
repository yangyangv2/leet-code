package prob244.shortest.word.distance.ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 1/20/2018.
 */
public class WordDistance {

    private Map<String, List<Integer>> dict;


    public WordDistance(String[] words) {
        dict = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i ++){
            String word = words[i];
            List<Integer> list = dict.get(word);
            if(list == null){
                list = new ArrayList<Integer>();
                dict.put(word, list);
            }
            list.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = dict.get(word1);
        List<Integer> list2 = dict.get(word2);
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while(i < list1.size() && j < list2.size()){
            int pos1 = list1.get(i);
            int pos2 = list2.get(j);
            if(pos1 < pos2){
                res = Math.min(res, pos2 - pos1);
                i ++;
            } else {
                res = Math.min(res, pos1 - pos2);
                j ++;
            }
        }
        return res;

    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */