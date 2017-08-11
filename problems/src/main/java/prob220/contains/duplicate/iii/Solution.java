package prob220.contains.duplicate.iii;

import java.util.TreeSet;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums == null || nums.length == 0){
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        long lt = (long) t;

        for(int i = 0; i < nums.length; i ++){

            Long ceiling = set.ceiling(nums[i] - lt);
            Long floor = set.floor(nums[i] + lt);

            if((ceiling != null && ceiling <= nums[i]) ||
                    (floor != null && floor >= nums[i])){
                return true;
            }
            set.add((long)nums[i]);
            if(set.size() > k){
                set.remove((long)nums[i - k]);
            }

        }

        return false;
    }
}