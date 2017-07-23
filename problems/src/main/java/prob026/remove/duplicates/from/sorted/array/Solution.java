package prob026.remove.duplicates.from.sorted.array;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        assert 3 == solution.removeDuplicates(new int[]{1,1,1,2,2,3});
    }

    public int removeDuplicates(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        // n > 2;
        int index = 0;
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] != nums[i - 1]){
                // set last value
                nums[index] = nums[i - 1];
                index ++;
            }
        }

        nums[index] = nums[nums.length - 1];

        return index + 1;
    }
}
