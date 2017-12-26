package prob059.spiral.matrix.ii;

public class Solution {

    /*
            top
         *-------|*
         _        |
    left |        |  right
         |        _
         *|-------*
            bottom

    */
    public int[][] generateMatrix(int n) {

        if(n == 0) return new int[0][0];
        int[][] m = new int[n][n];
        if(n == 1) {
            m[0][0] = 1;
            return m;
        }

        int top = 0, left = 0, right = n - 1, bottom = n - 1;
        int num = 0;

        while(left < right){
            for(int i = left; i < right; i ++)
                m[top][i] = ++num;

            for(int i = top; i < bottom; i ++)
                m[i][right] = ++ num;

            for(int i = right; i > left; i --)
                m[bottom][i] = ++ num;

            for(int i = bottom; i > top; i --)
                m[i][left] = ++ num;

            left ++; top ++; right --; bottom --;
        }

        if(n % 2 == 1){
            m[n/2][n/2] = ++num;
        }

        return m;
    }
}