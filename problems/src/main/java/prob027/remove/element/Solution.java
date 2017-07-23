package prob027.remove.element;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        assert 2 == solution.removeElement(new int[]{3,2,2,3}, 3);
    }

        /*
    Solution:
        1. count deletion
        2. move (compact) array elements
    */

    public int removeElement(int[] nums, int val) {

        int deletes = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == val){
                deletes ++;
                continue;
            } else if(deletes > 0){
                nums[i - deletes] = nums[i];
            }
        }
        return nums.length - deletes;
    }
}
