package prob007.reverse.integer;

/**
 * Created by yanya04 on 8/20/2017.
 */
class Solution {

/*
    edge cases:

    1. negative
    2. 0s
    3. overflow

*/


    public int reverse(int x) {


        long v = (long)x;

        boolean positive = v >= 0 ? true: false;

        String str = String.valueOf(Math.abs(v));

        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length / 2; i ++){
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }


        long num = Long.parseLong(new String(chars));
        if(positive && num > Integer.MAX_VALUE){
            return 0;
        } else if(!positive && num > Integer.MAX_VALUE + 1L){
            return 0;
        }

        if(positive){
            return (int)num;
        } else {
            return -1 * (int) num;
        }
    }

}
