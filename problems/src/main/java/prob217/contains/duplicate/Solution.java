package prob217.contains.duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num: nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
