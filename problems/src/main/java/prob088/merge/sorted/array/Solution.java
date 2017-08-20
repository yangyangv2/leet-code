package prob088.merge.sorted.array;

/**
 * Created by yanya04 on 8/20/2017.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for(int i = m - 1; i >= 0; i --){
            nums1[i + n] = nums1[i];
        }

        int mIdx = 0, nIdx = 0;

        while(mIdx + nIdx < m + n){

            if(mIdx == m){
                while(nIdx < n){
                    nums1[mIdx + nIdx] = nums2[nIdx];
                    nIdx ++;
                }
            } else if(nIdx == n){
                while(mIdx < m){
                    nums1[mIdx + nIdx] = nums1[mIdx + n];
                    mIdx ++;
                }
            } else {
                if(nums1[mIdx + n] < nums2[nIdx]){
                    nums1[mIdx + nIdx] = nums1[mIdx + n];
                    mIdx ++;
                } else {
                    nums1[mIdx + nIdx] = nums2[nIdx];
                    nIdx ++;
                }
            }
        }
    }
}