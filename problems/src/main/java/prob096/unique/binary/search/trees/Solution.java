package prob096.unique.binary.search.trees;

/**
 * Created by yanya04 on 1/8/2018.
 * Modified by yanya04 on 5/25/2018.
 */
public class Solution {

    /*
         [0, i-1]   [i] [i+1 ..n]

         f[n] = sum( f[i - 1] * f[n - i - 1] )
    */
    public int numTrees(int n) {
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for(int i = 2; i <= n; i ++){ // i is root
            for(int j = 0; j < i; j ++){
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }
}