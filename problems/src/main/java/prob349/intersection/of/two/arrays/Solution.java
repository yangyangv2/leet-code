package prob349.intersection.of.two.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanya04 on 8/19/2017.
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> output = new HashSet<>();

        for(Integer num: nums1){
            set.add(num);
        }

        for(Integer num: nums2){
            if(set.contains(num)){
                output.add(num);
            }
        }
        int[] result = new int[output.size()];
        int i = 0;
        for(Integer num: output){
            result[i ++] = num;
        }


        return result;
    }
}
