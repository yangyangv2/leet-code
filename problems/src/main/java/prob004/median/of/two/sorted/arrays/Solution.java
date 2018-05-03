package prob004.median.of.two.sorted.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 7/22/2017.
 * Modified by yanya04 on 5/2/2018.
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums1 = new int[]{2,5,8,10,12};
        int[] nums2 = new int[]{1,3,4,6,8,9,14};

        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1) return (double) findKth(nums1, 0, nums2, 0, len / 2 + 1);
        else return (findKth(nums1, 0, nums2, 0, len / 2) +
                findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }


    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k){

        debug(nums1, start1, nums2, start2, k);

        if(start1 >= nums1.length) return nums2[start2 + k - 1];
        if(start2 >= nums2.length) return nums1[start1 + k - 1];

        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1]: Integer.MAX_VALUE;
        int mid2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1]: Integer.MAX_VALUE;

        if(mid1 < mid2){
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }


    private void debug(int[] nums1, int start1, int[] nums2, int start2, int k){
        System.out.print("start=" + start1 + ", start2=" + start2 + ", k=" + k + " \t\t");
        List<String> elements = new ArrayList<>();
        for(int i = 0; i < nums1.length; i ++){
            if(i == start1) elements.add("|");
            elements.add(String.valueOf(nums1[i]));
        }

        if(start1 >= nums1.length) elements.add("|");

        elements.add("||");
        for(int i = 0; i < nums2.length; i ++){
            if(i == start2) elements.add("|");
            elements.add(String.valueOf(nums2[i]));
        }

        if(start2 >= nums2.length) elements.add("|");

        System.out.println(String.join(" ", elements));
    }
}
