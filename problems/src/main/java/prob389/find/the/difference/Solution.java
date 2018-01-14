package prob389.find.the.difference;

/**
 * Created by yanya04 on 1/13/2018.
 */
public class Solution {
    public char findTheDifference(String s, String t) {

        char[] nums1 = s.toCharArray();
        char[] nums2 = t.toCharArray();
        char diff = 0;
        for(int i = 0; i < nums1.length; i++){
            diff ^= nums1[i];
        }
        for(int i = 0; i < nums2.length; i++){
            diff ^= nums2[i];
        }

        return diff;

    }
}