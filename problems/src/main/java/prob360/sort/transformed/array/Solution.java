package prob360.sort.transformed.array;

/**
 * Created by yanya04 on 8/27/2017.
 * Modified by yanya04 on 5/24/2018.
 */
public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int start = 0, end = n - 1, index = a > 0? n -1 : 0;

        while(start <= end){

            int left = cal(nums[start], a, b, c);
            int right = cal(nums[end], a, b, c);
            if(a > 0){
                if(left > right){
                    res[index --] = left;
                    start++;
                } else{
                    res[index --] = right;
                    end --;
                }
            } else {
                if(left > right){
                    res[index ++] = right;
                    end --;
                } else{
                    res[index ++] = left;
                    start ++;
                }
            }
        }
        return res;
    }

    private int cal(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}