package prob414.third.maximum.number;

import java.util.*;

/**
 * Created by yanya04 on 8/17/2017.
 */
public class Solution {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length ; i ++){
            if(!set.contains(nums[i])){
                queue.add(nums[i]);
                set.add(nums[i]);
            }
            if(queue.size() > 3){
                set.remove(queue.poll());
            }
        }
        ArrayList<Integer> list = new ArrayList<>(queue);
        Collections.sort(list);
        if(set.size() < 3){
            return list.get(list.size() - 1);
        } else {
            return list.get(0);
        }
    }
}