package prob360.sort.transformed.array;

/**
 * Created by yanya04 on 8/27/2017.
 */
public class Solution {

/*
    f(x) = ax2 + bx + c

    split sorted array by -b/2a;

    merge insert

*/

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {

        int[] result = new int[nums.length];

        if(a == 0) {
            for(int i = 0; i < nums.length; i ++){
                result[i] = cal(nums[i], a, b, c);
            }
            if (b < 0){
                reverse(result);
            }
        } else {
            int i = 0, j = nums.length - 1;
            int count = 0;
            while(i <= j){
                int cal1 = cal(nums[i], a, b, c);
                int cal2 = cal(nums[j], a, b, c);
                if(a > 0){
                    // find the max, and then reverse
                    if(cal1 > cal2){
                        result[count] = cal1;
                        i ++;
                    } else {
                        result[count] = cal2;
                        j --;
                    }
                } else {
                    // find the min and return
                    if(cal1 < cal2){
                        result[count] = cal1;
                        i ++;
                    } else {
                        result[count] = cal2;
                        j --;
                    }
                }
                count ++;
            }
            if(a > 0) reverse(result);
        }
        return result;
    }

    private void reverse(int[] nums){
        int i = 0, j = nums.length -1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++; j --;
        }
    }

    private int cal(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}