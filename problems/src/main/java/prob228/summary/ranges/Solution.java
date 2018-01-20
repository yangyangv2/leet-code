package prob228.summary.ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/19/2018.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        summary(nums, 0, result);

        return result;
    }

    private void summary(int[] nums, int index, List<String> result){

        if(index == nums.length) return;

        int start = index;
        int end = index;
        for(int i = start; i < nums.length - 1; i ++){
            if(nums[i] + 1 == nums[i + 1]){
                end = i + 1;
            } else {
                break;
            }
        }

        if(start == end){
            result.add(String.valueOf(nums[start]));
        } else {
            result.add(String.valueOf(nums[start] + "->" + nums[end]));
        }

        summary(nums, end + 1, result);
    }
}