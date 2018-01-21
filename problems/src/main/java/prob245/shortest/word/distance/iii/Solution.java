package prob245.shortest.word.distance.iii;

/**
 * Created by yanya04 on 1/20/2018.
 */
public class Solution {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        int pos1 = -1, pos2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i ++){
            String word = words[i];
            if(word1.equals(word)){
                if(word1.equals(word2)){
                    if(pos1 == -1){
                        pos1 = i;
                        continue;
                    } else if(pos1 < pos2){
                        pos1 = i;
                    } else {
                        pos2 = i;
                    }
                    res = Math.min(res, Math.abs(pos1 - pos2));
                } else {
                    pos1 = i;
                    if(pos2 != -1)
                        res = Math.min(res, Math.abs(pos1 - pos2));
                }
            }
            else if(word2.equals(word)){
                pos2 = i;
                if(pos1 != -1)
                    res = Math.min(res, Math.abs(pos1 - pos2));
            }
        }
        return res;
    }
}
