package prob137.single.number.ii;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
/*
    idea:

    count the number of 1s of each bit
    module by 3

    for example
    [1 4 4 4 3 3 3]


idx 0123
    0001
    0100
    0100
    0100
    0011
    0011
    0011

    bit[0] = 0 % 3 = 0
    bit[1] = 3 % 3 = 0
    bit[2] = 3 % 3 = 0
    bit[3] = 4 % 3 = 1

    ans = 0001 = 1


    0100 + 0100 + 0100 = 0

    Complexity: O(n)
    Space:      O(32)

*/


    public int singleNumber(int[] nums) {

        int result = 0;
        int[] bits = new int[32];
        for(int i = 0; i < 32; i ++){
            for(int j = 0; j < nums.length; j ++){
                int bit = nums[j] >> i & 1;
                if(bit == 1){
                    bits[i] ++;
                }
            }
        }

        for(int i = 0; i < 32; i ++){
            result |= (bits[i] % 3) << i;
        }
        return result;
    }
}