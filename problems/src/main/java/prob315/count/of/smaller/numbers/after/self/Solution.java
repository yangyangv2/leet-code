package prob315.count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 3/5/2018.
 * Modified by yanya04 on 5/10/2018.
 */
public class Solution {

    class BIT {
        int[] count;
        BIT(int n){
            count = new int[n + 1];
        }

        void update(int index){
            while(index < count.length){
                count[index] += 1;
                index += index & (- index);
            }
        }

        int find(int index){
            int sum = 0;
            while(index > 0){
                sum += count[index];
                index -= index & (- index);
            }
            return sum;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        Arrays.sort(copy);

        List<Integer> res = new ArrayList<>();
        BIT bit = new BIT(n);
        int index = 0;
        for(int i = nums.length - 1; i >= 0; i --){
            index = Arrays.binarySearch(copy, nums[i]) + 1;
            res.add(0, bit.find(index - 1));
            bit.update(index);
        }
        return res;
    }
}