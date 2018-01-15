package prob164.maximum.gap;
import java.util.Arrays;

import static java.lang.Math.*;
/**
 * Created by yanya04 on 1/15/2018.
 */
public class Solution {
    /*
    gap  1 2 5  0  14
        1 3 6 12 13 28

        13 6 28 1 12 3

        1. find min/max = 1,28
        2. calculate average gap = (max - min) / 6 = 27 / 6 = 4
        3. bucket
           1-6 7-12 13-18 19-24 25-28
            1   12    13          28
            3
            6
    gap       6    0         14
    */
    public int maximumGap(int[] nums) {

        if(nums == null || nums.length < 2)
            return 0;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int n = nums.length;
        for(int num: nums){
            max = max(max, num);
            min = min(min, num);
        }

        if(max == min)
            return 0;

        int gap = (int)ceil((double)(max - min) / (n - 1));

        int[] bmax = new int[n - 1];
        int[] bmin = new int[n - 1];

        Arrays.fill(bmax, Integer.MIN_VALUE);
        Arrays.fill(bmin, Integer.MAX_VALUE);

        for(int num: nums){
            if(num == max) continue;
            int bucket = (num - min) / gap;
            bmax[bucket] = max(num, bmax[bucket]);
            bmin[bucket] = min(num, bmin[bucket]);
        }

        int res = 0;

        int pre = bmax[0];
        for(int i = 1; i < n - 1; i ++){
            if(bmin[i] == Integer.MAX_VALUE && bmax[i] == Integer.MIN_VALUE)
                continue;

            res = max(bmin[i] - pre, res);
            pre = bmax[i];
        }
        res = max(res, max - pre);
        return res;
    }
}
