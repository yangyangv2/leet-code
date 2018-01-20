package prob238.product.of.array.except.self;

/**
 * Created by yanya04 on 1/20/2018.
 */
public class Solution {
    /*
        [1,2,3,4]
        [24,12,8,6]

        2 x 3 x 4 = 24
        1 x 3 x 4 = 12
        1 x 2 x 4 = 8
        1 x 2 x 3 = 6




    */
    public int[] productExceptSelf(int[] nums) {

        return spaceO1(nums);
    }

    private int[] spaceO1(int[] nums){

        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i ++)
            res[i] = res[i - 1] * nums[i - 1];
        int right = 1;
        for(int i = n - 2; i >= 0; i --){
            right *= nums[i + 1];
            res[i] = res[i] * right;
        }
        return res;
    }



    /*
        left[i] = left product up to i;
        right[i] = right product upto i;

    */
    private int[] spaceON(int[] nums){
        int n = nums.length;
        int[] output = new int[n];


        int[] leftProd = new int[n];
        leftProd[0] = nums[0];
        for(int i = 1; i < n; i ++)
            leftProd[i] = leftProd[i - 1] * nums[i];

        int[] rightProd = new int[n];
        rightProd[n -1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i --)
            rightProd[i] = rightProd[i + 1] * nums[i];


        for(int i = 0; i < n; i ++){

            if(i == 0)
                output[i] = rightProd[i + 1];
            else if(i == n - 1)
                output[i] = leftProd[i - 1];
            else
                output[i] = rightProd[i + 1] * leftProd[ i - 1];
        }

        return output;
    }



}
