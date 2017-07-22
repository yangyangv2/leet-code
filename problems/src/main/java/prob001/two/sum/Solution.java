package prob001.two.sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 7/22/2017.
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(
                solution.twoSum(nums, 9))
        );
    }

    public int[] twoSum(int[] nums, int target) {
        // key: num, value: index
        Map<Integer, Integer> cache = new HashMap<>();

        for(int i = nums.length - 1; i > -1; i --){
            int remain = target - nums[i];
            Integer index = cache.get(remain);
            if(index != null && index != i){
                return new int[]{i, index};
            }
            cache.put(nums[i], i);
        }
        // not possible
        throw new IllegalArgumentException("no solution");
    }
}
