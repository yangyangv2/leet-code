package prob220.contains.duplicate.iii;

import java.util.TreeSet;

/**
 * Created by yanya04 on 8/10/2017.
 * Modified by yanya04 on 5/9/2018.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums == null || nums.length == 0) return false;

        int start = 0, end = 0;
        Long floor = null, ceiling = null;
        TreeSet<Long> ts = new TreeSet<>();
        while(end < nums.length){

            floor = ts.floor((long)nums[end]);
            ceiling = ts.ceiling((long)nums[end]);

            if(floor != null && nums[end] - floor <= t){
                return true;
            }

            if(ceiling != null && ceiling - nums[end] <= t){
                return true;
            }

            ts.add((long)nums[end]);
            end ++;

            if(end > k){
                ts.remove((long)nums[start]);
                start ++;
            }
        }
        return false;
    }
}