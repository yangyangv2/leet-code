package prob245.shortest.word.distance.iii;

/**
 * Created by yanya04 on 1/20/2018.
 * Modified by yanya04 on 5/14/2018.
 */
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int n = words.length, shortest = n, idx1 = -1, idx2 = -1;
        if(word1.equals(word2)){
            for(int i = 0; i < n; i ++){
                if(words[i].equals(word1)){
                    idx2 = idx1;
                    idx1 = i;
                }
                if(idx1 != -1 && idx2 != -1) {
                    shortest = Math.min(shortest, idx1 - idx2);
                }
            }
        } else {
            for(int i = 0; i < n; i ++){
                if(words[i].equals(word1)){
                    idx1 = i;
                } else if(words[i].equals(word2)){
                    idx2 = i;
                }
                if(idx1 != -1 && idx2 != -1) {
                    shortest = Math.min(shortest, Math.abs(idx1 - idx2));
                }
            }
        }
        return shortest;
    }
}
