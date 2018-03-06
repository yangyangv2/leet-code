package prob315.count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 3/5/2018.
 */
public class Solution {

    /*
        Solution:

        Given:  5, 2, 6, 1
        start from the tail, doing the insert sort:

        insert 1 at 0   [1]
        insert 6 at 1   [1, 6]
        insert 2 at 1   [1, 2, 6]
        insert 5 at 2   [1, 2, 5, 6]


        0, 1, 1, 2 => reverse 2, 1, 1, 0

    */

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();
        for(int i = nums.length - 1; i > -1; i --){
            int num = nums[i];
            int index = findIndex(list, num);
            list.add(index, num);
            res[i] = index; // number of nums smaller than num
        }
        return Arrays.asList(res);
    }

    private int findIndex(List<Integer> list, int target){
        if(list.isEmpty()) return 0;

        int start = 0, end = list.size() - 1;
        if(list.get(start) >= target) return 0;
        if(list.get(end) < target) return end + 1;

        while(start + 1 < end){
            int mid = (end - start) / 2 + start;
            if(list.get(mid) < target){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if(list.get(start) >= target) return start;
        return end;
    }



}
