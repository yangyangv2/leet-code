package prob496.next.greater.element.i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by yanya04 on 6/1/2018.
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Map<Integer, Integer> nextLarge = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int num: nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                nextLarge.put(stack.pop(), num );
            }
            stack.push(num);
        }

        for(int i = 0; i < n; i ++){
            res[i] = nextLarge.getOrDefault(nums1[i], - 1);
        }
        return res;
    }
}