package prob229.majority.element.ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*
        Boyer Moore
    */

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if(nums == null || nums.length == 0) return result;

        int major1 = -1, major2 = -1, count1 = 0, count2 = 0;

        for(int i = 0; i < nums.length; i ++){
            if (major1 == nums[i]){
                count1 ++;
            } else if (major2 == nums[i]){
                count2 ++;
            } else if(count1 == 0){
                major1 = nums[i];
                count1 ++;
            } else if (count2 == 0){
                major2 = nums[i];
                count2 ++;
            } else {
                count1 --;
                count2 --;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == major1) count1 ++;
            else if(nums[i] == major2) count2 ++;
        }

        if(count1 > nums.length / 3) result.add(major1);
        if(count2 > nums.length / 3) result.add(major2);


        return result;
    }
}