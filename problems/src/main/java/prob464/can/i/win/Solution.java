package prob464.can.i.win;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  Created by yanya04 on 5/27/2018.
 *  
 */
public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        int max = maxChoosableInteger, total = desiredTotal;
        if( max *( max + 1) / 2 < desiredTotal) return false;

        int[] used = new int[max + 1];
        Map<String, Boolean> map = new HashMap<>();
        if(total <= max) return true;
        return backtrack(total, max, used, map);
    }

    private boolean backtrack(int remaining, int max, int[] used, Map<String, Boolean> map){
        if(remaining <= 0)
            return false;

        String key = Arrays.toString(used);
        if(map.containsKey(key)){
            return map.get(key);
        }

        for(int i = 1; i <= max; i ++){
            if(used[i] == 1) continue;
            used[i] = 1;
            if(!backtrack(remaining - i, max, used, map)){
                map.put(key, true);
                used[i] = 0;
                return true;
            }
            used[i] = 0;
        }

        map.put(key, false);
        return false;
    }

}