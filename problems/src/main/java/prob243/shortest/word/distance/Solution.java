package prob243.shortest.word.distance;

/**
 * Created by yanya04 on 1/20/2018.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {

        int idx1 = -1, idx2 = -1, shortest = Integer.MAX_VALUE;

        for(int i = 0; i < words.length; i ++){

            if(words[i].equals(word1)){
                idx1 = i;
            } else if(words[i].equals(word2)){
                idx2 = i;
            }

            if(idx1 != -1 && idx2 != -1){
                shortest = Math.min(shortest, Math.abs(idx1 - idx2));
            }

        }

        return shortest;
    }
}
