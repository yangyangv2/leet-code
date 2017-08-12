package prob018.four.sum;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println( solution.fourSum(new int[]{1,0,-1,0,-2,2}, 0));

    }

    /*
    Solution1:

    1. sort                 (O(n*log(n)))
    2. divide and conquer   (O(n^3))
    3. three sum            (O(n^2))
    4. two sum              (O(n))



    */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length < 4) return result;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i ++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            threeSum(nums, i, target - nums[i], result);
        }

        return result;
    }

    private void threeSum(int[] nums, int start, int target, List<List<Integer>> result){

        for(int i = start + 1; i < nums.length; i ++){
            if(i > start + 1 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target){ // found!
                    result.add(Arrays.asList(nums[start], nums[i], nums[l], nums[r]));
                    l ++; r--;
                    // skip duplicates
                    while(l < nums.length - 1 && nums[l] == nums[l - 1]) l ++;
                    while(r > 0 && nums[r] == nums[r + 1]) r --;
                } else if(sum > target){
                    r --;
                } else {
                    l ++;
                }
            }
        }
    }
}
