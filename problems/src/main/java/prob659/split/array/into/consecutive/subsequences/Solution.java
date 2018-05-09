package prob659.split.array.into.consecutive.subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanya04 on 5/8/2018.
 */
public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        int n = nums.length, num = 0;
        for (int i = 0; i < nums.length; i ++) {
            num = nums[i];
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }

        for (int i = 0; i < nums.length; i ++) {
            num = nums[i];
            if (freq.get(num) == 0) {
                continue;
            }
            else if (appendfreq.getOrDefault(num, 0) > 0) {
                appendfreq.put(num, appendfreq.get(nums) - 1);
                appendfreq.put(num + 1, appendfreq.getOrDefault(num + 1,0) + 1);
            }
            else if (freq.getOrDefault(num + 1, 0) > 0 && freq.getOrDefault(num + 2, 0) > 0) {
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);
                appendfreq.put(num + 3, appendfreq.getOrDefault(num + 3, 0) + 1);
            }
            else {
                return false;
            }
            freq.put(num, freq.get(num) - 1);
        }
        return true;
    }
}