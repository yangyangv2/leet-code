package prob318.maximum.product.of.word.lengths;

/**
 * Created by yanya04 on 3/6/2018.
 */
public class Solution {

    /*
        bitmap check collision
    */


    public int maxProduct(String[] words) {

        int[] map = new int[words.length];
        for(int i = 0; i < words.length; i ++){
            String word = words[i];
            int v = 0;
            for(char c: word.toCharArray()){
                v |= 1 << c - 'a';
            }
            map[i] = v;
        }

        int res = 0;

        for(int i = 0; i < words.length; i ++){
            for(int j = 0; j < words.length; j ++){
                if(i == j) continue;
                if((map[i] & map[j]) == 0){
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }
}