package prob248.strobogrammatic.number.iii;

import java.util.*;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {
    public int strobogrammaticInRange(String low, String high) {

        Set<String> set = new HashSet<>();
        for(int i = low.length(); i <= high.length(); i ++){
            set.addAll(backtrack(i, i));
        }

        int rec = 0;
        for(String str: set){
            if(str.length() == low.length() && str.compareTo(low) < 0) continue;
            if(str.length() == high.length() && str.compareTo(high) > 0) continue;
            rec ++;
        }

        return rec;
    }


    private List<String> backtrack(int cur, int max){

        if(cur == 0) return new ArrayList<String>(Arrays.asList(new String[]{""}));
        if(cur == 1) return new ArrayList<String>(Arrays.asList(new String[]{"0", "1", "8"}));

        List<String> list = backtrack(cur - 2, max);

        List<String> result = new ArrayList<>();
        for(String str: list){
            if(cur != max)
                result.add("0" + str + "0");
            result.add("1" + str + "1");
            result.add("8" + str + "8");
            result.add("6" + str + "9");
            result.add("9" + str + "6");
        }
        return result;
    }
}
