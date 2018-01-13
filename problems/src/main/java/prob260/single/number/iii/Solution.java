package prob260.single.number.iii;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
    /*
        example [1 2 1 3 2 5]

        0001
        0010
        0001
        0011
        0010
        0101

        XOR => 3 XOR 5 => 0011 xor 0101 = 0110

        diff

    */
    public int[] singleNumber(int[] nums) {


        int axorb = 0;
        for(int i = 0; i < nums.length; i ++)
            axorb ^= nums[i];

        int rightmost = 0;
        for(int i = 0; i < 32; i ++){
            if(((axorb >> i) & 1) == 1){
                rightmost = i;
                break;
            }
        }

        rightmost = 1 << rightmost;

        int num1 = 0, num2 = 0;

        for(int i = 0; i < nums.length; i ++){
            if((nums[i] & rightmost) == 0){
                // group 1
                num1 ^= nums[i];
            } else {
                num2 ^= nums[i];
            }
        }
        return new int[]{num1, num2};
    }
}
