package prob448.find.all.numbers.disappeared.in.an.array;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /*       0 1 2 3 4 5 6 7
            [4,3,2,7,8,2,3,1]
             - - - -     - -
    */

    private void touch(int[] nums, int i){

        int index = Math.abs(nums[i]) - 1;

        if(nums[index] > 0)
            nums[index] = -nums[index];
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i = 0; i < nums.length; i ++)
            touch(nums, i);

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > 0)
                result.add(i + 1);
        }

        return result;
    }
}