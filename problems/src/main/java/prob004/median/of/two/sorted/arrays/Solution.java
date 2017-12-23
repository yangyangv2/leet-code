package prob004.median.of.two.sorted.arrays;

import java.util.Arrays;

/**
 * Created by yanya04 on 7/22/2017.
 */
public class Solution {
    /*  index       0   1   2   3   4   5   6   7   8
        m           1   3   4   6   8 i 9   10  11  13
        n           2   5   6 j 7   9   15

        total #     9 + 6 = 15

        m[i] < n[j + 1]
        n[j] < m[i + 1]
                                    (edge i/j == 0)      (edge i = m/j = n)
        total # is even =>  avg(max(m[i], n[j]), min(n[j + 1], m[i + 1]))
              # is odd  =>  max(m[i], n[k])
        edge cases:
                i = 0

    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] lg, sm;
        if(nums1.length > nums2.length){
            lg = nums1;
            sm = nums2;
        } else {
            lg = nums2;
            sm = nums1;
        }

        int m = sm.length, n = lg.length;
        // partitions on small array
        int l = 0, r = m;
        int k = (m + n + 1) / 2;

        while(l <= r){

            int p1 = (l + r) >>>1;
            int p2 = k - p1;

            int lmax1 = (p1 == 0) ? Integer.MIN_VALUE: sm[p1 - 1];
            int rmin1 = (p1 == m) ? Integer.MAX_VALUE: sm[p1];

            int lmax2 = (p2 == 0) ? Integer.MIN_VALUE: lg[p2 - 1];
            int rmin2 = (p2 == n) ? Integer.MAX_VALUE: lg[p2];


            if(lmax1 <= rmin2 && lmax2 <= rmin1){
                if( (m + n) % 2 == 0 ) return (Math.max(lmax1, lmax2) + Math.min(rmin2, rmin1)) / 2.0;
                else return Math.max(lmax1, lmax2);
            } else if(lmax1 > rmin2){
                r = p1 - 1;
            } else {
                l = p1 + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
