package prob220.contains.duplicate.iii;

import java.util.TreeSet;

/**
 * Created by yanya04 on 8/10/2017.
 * Modified by yanya04 on 5/9/2018.
 * Modified by yanya04 on 5/28/2018.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> set = new TreeSet<>();

        long lt = (long) t;
        for(int i = 0; i < nums.length; i ++){

            // get the upper bound
            Long floor = set.floor(nums[i] + lt);

            // get the lower bound
            Long ceiling = set.ceiling(nums[i] - lt);

            if(floor != null && floor >= nums[i]  ||
                    ceiling != null && ceiling <= nums[i])
                return true;

            set.add((long)nums[i]);
            if(set.size() > k){
                set.remove((long)nums[i - k]);
            }
        }

        return false;
    }
}