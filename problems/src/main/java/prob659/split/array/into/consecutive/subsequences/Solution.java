package prob659.split.array.into.consecutive.subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 5/8/2018.
 * Modified by yanya04 on 6/3/2018.
 */
public class Solution {
    /*
        1,2,3,3,4,4,5
        3 4 5
        1 2 3 4

    */
    public boolean isPossible(int[] nums) {
        int max = nums[nums.length - 1];

        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> expects = new HashMap<>();


        for(int num: nums){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for(int num: nums){

            if(counts.getOrDefault(num, 0)  == 0) continue;

            else if(expects.getOrDefault(num, 0) > 0){
                expects.put(num, expects.getOrDefault(num, 0) - 1);
                expects.put(num + 1, expects.getOrDefault(num + 1, 0) + 1);
            }
            else if(counts.getOrDefault(num + 1, 0) > 0 && counts.getOrDefault(num + 2, 0) > 0){
                expects.put(num + 3, expects.getOrDefault(num + 3, 0) + 1);
                counts.put(num + 1, counts.getOrDefault(num + 1, 0) - 1);
                counts.put(num + 2, counts.getOrDefault(num + 2, 0) - 1);
            } else {
                // the number has no where to go
                return false;
            }
            counts.put(num, counts.getOrDefault(num, 0) - 1);

        }
        return true;

    }
}