package prob321.create.maximum.number;

import java.util.Stack;

/**
 * Created by yanya04 on 3/8/2018.
 */
public class Solution {

    /*
        if  select [i] nums from m
            select [k - i] nums from n

        and the anser is the largest, then [i] is the largest array on m, and [k -i] is the largest array on n

        function 1: find largest array of i elements on a given array
        function 2: find largest array from array1 and array2
        function 3: check if array1 is larger than array2
        function 4: go through all the combination of [i] and [k - i] on two arrays
    */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;

        int[] res = null;

        for(int i = 0; i <= Math.min(m, k); i ++){
            int j = Math.max(k - i, 0);
            if(j > nums2.length) continue;

            int[] arr1 = max(nums1, i);
            int[] arr2 = max(nums2, j);

            int[] temp = merge(arr1, arr2);

            if(res == null || larger(temp, res)){
                res = temp;
            }
        }
        return res;
    }

    /*
        if array nums1 is larger than nums2, num1.len == num2.len
        Complexity: O(n);
    */
    private boolean larger(int[] nums1, int[] nums2)
    {
        int len = nums1.length;

        if(nums1.length != nums2.length){
            return nums1.length > nums2.length;
        }

        for(int i = 0; i < len; i ++){
            if(nums1[i] > nums2[i])
                return true;
            if(nums1[i] < nums2[i])
                return false;
        }

        // if nums1 == nums2, then nums1 is larger than nums2
        return true;
    }

    /*
        find largest array from array1 and array2
        Complexity: O(n)
    */
    private int[] merge(int[] nums1, int[] nums2)
    {
        int m = nums1.length, n = nums2.length;

        int i = 0, j = 0;
        int[] res = new int[m + n];
        for(int k = 0; k < res.length; k ++){
            if(i < m && j < n){
                if(nums1[i] > nums2[j]){
                    res[k] = nums1[i ++];
                } else if(nums1[i] < nums2[j]){
                    res[k] = nums2[j ++];
                } else {

                    int x = i, y = j;

                    while(x < m && y < n && nums1[x] == nums2[y]){
                        x ++; y ++;
                    }

                    if(x < m && y < n){
                        // nums1[x] != nums2[y]
                        if(nums1[x] > nums2[y]) res[k] = nums1[i ++];
                        else res[k] = nums2[j ++];
                    } else if(x < m){
                        res[k] = nums1[i ++];
                    } else if(y < n){
                        res[k] = nums2[j ++];
                    }
                }
            } else if(i < m) {
                res[k] = nums1[i ++];
            } else if(j < n){
                res[k] = nums2[j ++];
            }
        }

        return res;
    }


    /*
        find max k-length number from array

        a=[5 3 1 8 3], k = 3

        [5, 3, 1]
        [5, 8, 3]

        Complexity: O(n)
    */
    private int[] max(int[] nums, int k)
    {
        if(nums.length <= k)
            return nums;
        Stack<Integer> stack = new Stack();

        int removes = nums.length - k;
        for(int i = 0; i < nums.length; i ++){
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() < num && removes > 0){
                stack.pop();
                removes --;
            }

            if(stack.size() < k){
                stack.push(num);
            } else {
                removes --;
            }
        }

        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i --){
            res[i] = stack.pop();
        }

        return res;
    }
}