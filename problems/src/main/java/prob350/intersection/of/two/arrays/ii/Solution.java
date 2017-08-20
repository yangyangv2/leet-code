package prob350.intersection.of.two.arrays.ii;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

/**
 * Created by yanya04 on 8/19/2017.
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // assuming nums2 is the smaller one

        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for(int i = 0; i < nums2.length; i ++){
            map.put(nums2[i], map.getOrDefault(nums2[i], 0) + 1);
        }

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums1.length; i ++){
            int count = map.getOrDefault(nums1[i], 0);
            if(count > 0){
                map.put(nums1[i], count - 1);
                list.add(nums1[i]);
            }
        }

        int[] result = new int[list.size()];
        int count = 0;
        for(Integer num: list){
            result[count ++] = num;
        }
        return result;
    }
}
