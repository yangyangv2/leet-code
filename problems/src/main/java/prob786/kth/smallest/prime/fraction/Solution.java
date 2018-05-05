package prob786.kth.smallest.prime.fraction;

/**
 * Created by yanya04 On 5/4/2018.
 */
public class Solution {

    // count the numbers less than num
    // and return the maximum A[p] / A[q]
    private int[] count(int[] A, double mid){

        int count = 0, n = A.length;
        int p = 0, q = 1;
        for(int i = 0, j = 0; i < n; i ++){
            while(j < n && A[i] > mid * A[j]) j ++;
            count += n - j;
            if(j < n && A[i] * q > A[j] * p){
                p = A[i]; q = A[j];
            }
        }
        return new int[]{count, p, q};
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double lo = 0, hi = 1, mid = 0;
        int p = 0, q = 1;
        int n = A.length, count = 0;
        int[] meta = null;
        while (lo < hi) {

            mid = (lo + hi) / 2;

            meta = count(A, mid);
            count = meta[0];
            p = meta[1];
            q = meta[2];

            if (count < K) {
                lo = mid;
            } else if (count > K) {
                hi = mid;
            } else {
                break;
            }
        }

        return new int[]{p, q};
    }
}