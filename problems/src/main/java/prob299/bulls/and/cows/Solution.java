package prob299.bulls.and.cows;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 2/6/2018.
 */
public class Solution {
    public String getHint(String secret, String guess) {

        StringBuilder sb1 = new StringBuilder(secret);
        StringBuilder sb2 = new StringBuilder(guess);

        int aCount = 0;
        int bCount = 0;

        for(int i = 0; i < Math.min(sb1.length(), sb2.length()); ){
            if(sb1.charAt(i) == sb2.charAt(i)){
                sb1.deleteCharAt(i);
                sb2.deleteCharAt(i);
                aCount ++;
            } else {
                i ++;
            }
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c: sb1.toString().toCharArray()){
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        for(char c: sb2.toString().toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                bCount ++;
                if(count == 1)
                    map.remove(c);
                else
                    map.put(c, count - 1);
            }
        }

        return aCount + "A" + bCount + "B";
    }
}
