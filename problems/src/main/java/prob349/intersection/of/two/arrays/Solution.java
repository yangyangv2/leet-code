package prob349.intersection.of.two.arrays;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yanya04 on 8/19/2017.
 * Modified by yanya04 on 4/29/2018.
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        Set<Integer> is = new HashSet<>();
        for(int i = 0; i < nums1.length; i ++){
            set.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j ++){
            if(set.contains(nums2[j])){
                is.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        int[] res = new int[is.size()];
        int index = 0;
        Iterator<Integer> iter = is.iterator();
        while(iter.hasNext()){
            res[index ++] = iter.next();
        }
        return res;
    }
}