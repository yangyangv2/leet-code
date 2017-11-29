package prob169.majority.element;

public class Solution {
    public int majorityElement(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int major = 0, count = 0;

        for(int i = 0; i < nums.length; i ++){
            if(count == 0){
                major = nums[i];
                count ++;
            } else if(major == nums[i]){
                count ++;
            } else {
                count --;
            }
        }

        return major;
    }
}