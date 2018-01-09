package prob091.decode.ways;

/**
 * Created by yanya04 on 1/8/2018.
 */
public class Solution {

    // index    01234
    // input    1202
    // count      011


    public int numDecodings(String s) {

        // let f[i] = ways of decode

        if(s == null) return 0;

        int n = s.length();

        if(n == 0) return 0;

        int[] ways = new int[n + 1];

        ways[n] = 1;    // there's one way for empty
        ways[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;

        for(int i = n - 2; i >= 0; i --){
            if(s.charAt(i) == '0') {
                ways[i] = 0;
                continue;
            }

            int num = Integer.parseInt(s.substring(i, i + 2));

            if( num <= 26) {
                ways[i] = ways[i + 1] + ways[i + 2];
            } else {
                ways[i] = ways[i + 1];
            }
        }


        return ways[0];

    }
}