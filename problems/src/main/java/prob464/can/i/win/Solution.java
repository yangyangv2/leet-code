package prob464.can.i.win;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  Created by yanya04 on 5/27/2018.
 *  Modified by yanya04 on 6/1/2018.
 *  
 */
public class Solution {
    public boolean canIWin(int max, int total) {
        if(max * (max + 1) / 2 < total) return false;
        if(max >= total) return true;

        Map<String, Boolean> mem = new HashMap<>();
        int[] used = new int[max + 1];
        return backtrack(mem, used, max, total);
    }

    private boolean backtrack(Map<String, Boolean> mem, int[] used, int max, int total){
        if(total <= 0) return false;

        String key = Arrays.toString(used);
        if(mem.containsKey(key)){
            return mem.get(key);
        }

        boolean res = false;
        for(int i = 1; i <= max; i ++){
            if(used[i] == 1) continue;
            used[i] = 1;

            if(!backtrack(mem, used, max, total - i)){
                res = true;
                used[i] = 0;
                break;
            }
            used[i] = 0;
        }

        if(res) mem.put(key, true);
        else mem.put(key, false);
        return res;
    }
}