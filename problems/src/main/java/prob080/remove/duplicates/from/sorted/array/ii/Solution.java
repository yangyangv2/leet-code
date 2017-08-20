package prob080.remove.duplicates.from.sorted.array.ii;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 8/20/2017.
 */

class Solution {
    public int removeDuplicates(int[] nums) {
/*
    1
    1 1 1 2 2 3

    scan with map to count;
    if twice mark as duplicate
    move elements

*/
        Map<Integer, Integer> countMap = new HashMap<>();
        boolean[] bools =  new boolean[nums.length];
        Arrays.fill(bools, false);

        for(int i = 0; i < nums.length; i ++){
            Integer count = countMap.get(nums[i]);
            if(count == null){
                count = 1;
                countMap.put(nums[i], count);
            } else if (count < 2 ) {
                count += 1;
                countMap.put(nums[i], count);
            } else {
                bools[i] = true;
            }
        }

        int r = 0, w = 0;
        for(int i = 0; i < bools.length; i ++){

            if(r != w){
                nums[w] = nums[r];
            }

            if(!bools[i]){
                r ++;
                w ++;
            } else {
                r ++;
            }

        }
        return w;
    }
}
