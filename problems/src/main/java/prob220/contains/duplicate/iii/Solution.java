package prob220.contains.duplicate.iii;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by yanya04 on 8/10/2017.
 * Modified by yanya04 on 5/9/2018.
 * Modified by yanya04 on 5/28/2018.
 * Modified by yanya04 on 6/2/2018.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // return bucket(nums, k, t);
        return treeset(nums, k, t);
    }

    private boolean treeset(int[] nums, int k, int t){
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i ++){
            int num = nums[i];

            Long floor = set.floor((long)num + t);
            if( floor!= null && floor >= num)
                return true;

            Long ceiling = set.ceiling((long)num - t);
            if(ceiling != null && ceiling <= num)
                return true;

            set.add((long)num);

            if(set.size() > k){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }


    private boolean bucket(int[] nums, int k, int t){
        if (k < 1 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = align(nums[i]);
            long bucket = remappedNum / (t + 1L);
            if (    map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;

            if (map.entrySet().size() >= k) {
                long lastBucket = align(nums[i - k]) / (t + 1L);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }

    private long align(int num){
        return (long) num - Integer.MIN_VALUE;
    }

}