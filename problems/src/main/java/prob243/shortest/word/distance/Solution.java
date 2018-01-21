package prob243.shortest.word.distance;

/**
 * Created by yanya04 on 1/20/2018.
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {

        int res = Integer.MAX_VALUE;
        int pos1 = -1, pos2 = -1;
        for(int i = 0; i < words.length; i ++){
            String word = words[i];
            if(word1.equals(word))
                pos1 = i;
            else if(word2.equals(word))
                pos2 = i;

            if(pos1 != -1 && pos2 != -1)
                res = Math.min(res, Math.abs(pos1 - pos2));
        }
        return res;
    }
}
