package prob088.merge.sorted.array;

/**
 * Created by yanya04 on 8/20/2017.
 * Modified by yanya04 on 4/29/2018.
 */
public class Solution {

/*
    nums1 = [1,1,1,2,3,6], m = 3
             i k
    nums2 = [1,1,6],       n = 3
             j
*/

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = nums1.length - 1;

        while(i > -1 && j > - 1){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                k --; i --;
            } else {
                nums1[k] = nums2[j];
                k --; j --;
            }
        }

        while(j > -1){
            nums1[k--] = nums2[j--];
        }
    }
}