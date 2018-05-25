package prob334.increasing.triplet.subsequence;

/**
 *  created by yanya04 on 5/24/2018.
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, large = small;
        for(int num: nums){
            if(num <= small) small = num;
            else if(num <= large) large = num;
            else return true;
        }
        return false;
    }
}