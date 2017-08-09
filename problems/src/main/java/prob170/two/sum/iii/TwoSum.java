package prob170.two.sum.iii;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 8/9/2017.
 */
public class TwoSum {

    private Set<Integer> nums;
    private Set<Integer> cache;

    /** Initialize your data structure here. */
    public TwoSum() {
        nums = new HashSet<>();
        cache = new HashSet<>();

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(!nums.contains(number)){
            nums.add(number);
        } else {
            // duplicate
            cache.add(number);
        }
    }


    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer num : nums){
            if(nums.contains(value - num)){
                if(num == value - num){
                    if(cache.contains(num)){
                        return true;
                    }
                } else {
                    return true;
                }

            }
        }
        return false;
    }
}
