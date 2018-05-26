package prob363.max.sum.of.rectangle.no.larger.than.k;

/**
 *  Created by yanya04 on 5/25/2018.
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, ans = Integer.MIN_VALUE;
        long[] sum = new long[m + 1]; // stores sum of rect[0..p][i..j]
        for (int i = 0; i < n; i++) {
            long[] sumInRow = new long[m];
            for (int j = i; j < n; j++) { // for each rect[*][i..j]
                for (int p = 0; p < m; p++) {
                    sumInRow[p] += matrix[p][j];
                    sum[p + 1] = sum[p] + sumInRow[p];
                }
                ans = Math.max(ans, mergeSort(sum, 0, m, k));
                if (ans == k) return k;
            }
        }
        return ans;
    }
    //  sort, in the meanwhile, return the maximum sum of rectangle
    int mergeSort(long[] sum, int lo, int hi, int k) {
        if (hi == lo)
            return Integer.MIN_VALUE; // need at least 2 to proceed
        int mid = lo + (hi - lo)/2;

        int res = mergeSort(sum, lo, mid, k);
        if (res == k) return k;
        res = Math.max(res, mergeSort(sum, mid + 1, hi, k));
        if (res == k) return k;

        for (int i = lo, j = mid + 1; i <= mid; i ++) {
            while (j <= hi && sum[j] - sum[i] <= k){
                res = Math.max(res, (int)(sum[j] - sum[i]));
                if (res == k) return k;
                j++;
            }
        }
        merge(sum, lo, mid, hi);
        return res;
    }

    //  standard merge
    private void merge(long[] sum, int lo, int mid, int hi){
        int index = 0;
        long[] merge = new long[hi-lo+1];

        int i = lo, j = mid + 1;
        while(index < merge.length){
            long sum1 = (i > mid) ? Integer.MAX_VALUE: sum[i];
            long sum2 = (j > hi) ? Integer.MAX_VALUE: sum[j];
            merge[index ++] = (sum1 <= sum2) ? sum[i ++] : sum[j ++];
        }
        System.arraycopy(merge, 0, sum, lo, index);
    }

}