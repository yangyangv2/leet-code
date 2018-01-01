package prob313.superer.ugly.number;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int[] u = new int[n];
        int m = primes.length;
        int[] indexes = new int[m];

        u[0] = 1;
        for(int i = 1; i < n; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < m; j ++)
                min = Math.min(min, primes[j] * u[indexes[j]]);

            for(int j = 0; j < m; j ++){
                if(min == primes[j] * u[indexes[j]])
                    indexes[j] ++;
            }
            u[i] = min;
        }

        return u[n - 1];
    }
}