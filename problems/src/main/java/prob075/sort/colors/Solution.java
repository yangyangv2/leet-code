package prob075.sort.colors;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/5/2017.
 */
public class Solution {
    public void sortColors(int[] nums) {

        if(nums == null || nums.length == 0) return;

        int[] counts = new int[3];
        Arrays.fill(counts, 0);

        for(int i = 0; i < nums.length; i ++){
            counts[nums[i]] += 1;
        }

        int index = 0;
        for(int i = 0; i < counts.length; i++){
            for(int j = 0; j < counts[i]; j ++){
                nums[index] = i;
                index ++;
            }
        }

    }
}
