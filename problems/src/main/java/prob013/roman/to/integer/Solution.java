package prob013.roman.to.integer;

/**
 * Created by yanya04 on 8/19/2017.
 */
public class Solution {
    public int romanToInt(String s) {

        char[] chars = s.toCharArray();

        int[] nums = new int[chars.length];

        for(int i = 0; i < chars.length; i ++){
            switch(chars[i]){
                case 'I': nums[i] = 1;
                    break;
                case 'V': nums[i] = 5;
                    break;
                case 'X': nums[i] = 10;
                    break;
                case 'L': nums[i] = 50;
                    break;
                case 'C': nums[i] = 100;
                    break;
                case 'D': nums[i] = 500;
                    break;
                case 'M': nums[i] = 1000;
                    break;
            }
        }
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i ++){

            if(nums[i] < nums[i + 1]){
                sum -= nums[i];
            } else {
                sum += nums[i];
            }
        }

        sum += nums[nums.length - 1];

        return sum;
    }
}
