package prob219.contains.duplicates.ii;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class Solution
{
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            Integer index = map.get(nums[i]);
            if(index != null && i - index <= k ){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;

    }
}
