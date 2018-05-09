package prob072.edit.distance;

/**
 * Created by yanya04 on 1/3/2018.
 * Modified by yanya04 on 4/28/2018.
 * Moeified by yanya04 on 5/7/2018.
 */
public class Solution {

    /*
        f[i][j] be the minimum edits change str1 ended with [i] to str2 ended with [j]

        f[i][j] = min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1
                       delete[i]     insert         replace[i]

    */
    public int minDistance(String word1, String word2) {
        if(word1 == null) word1 = "";
        if(word2 == null) word2 = "";

        int m = word1.length(), n = word2.length();
        int[][] f = new int[2][n + 1];

        for(int j = 0; j <= n; j ++)
            f[0][j] = j;

        for(int i = 0; i < m; i ++){
            f[(i + 1) % 2][0] = i + 1;
            for(int j = 0; j < n; j ++){
                f[(i + 1) % 2][j + 1] = (word1.charAt(i) == word2.charAt(j)) ? f[i % 2][j] :
                        Math.min(Math.min(f[(i + 1) % 2][j], f[i % 2][j + 1]), f[i % 2][j]) + 1;
            }
        }

        return f[m % 2][n];

    }
}