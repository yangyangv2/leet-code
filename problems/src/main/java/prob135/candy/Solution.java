package prob135.candy;

import java.util.Arrays;

/**
 * Created by yanya04 on 1/12/2018.
 */
public class Solution {

    /*

        rate    1 5 2 6 7 4 1
        candy   1 1 1 1 1 1 1
                  1   1 1 1
                        1

    */
    public int candy(int[] ratings) {

        int n = ratings.length;

        int[] nums = new int[n];
        Arrays.fill(nums, 1);


        // left pass
        for(int i = 1; i < n; i ++){
            if(ratings[i] > ratings[i - 1])
                nums[i] = nums[i - 1] + 1;
        }

        // right pass
        for(int i = n - 2; i >= 0; i --){
            if(ratings[i] > ratings[i + 1])
                if(nums[i] <= nums[i + 1])
                    nums[i] = nums[i + 1] + 1;
        }

        int sum = 0;
        for(Integer num: nums)
            sum += num;

        return sum;
    }
}