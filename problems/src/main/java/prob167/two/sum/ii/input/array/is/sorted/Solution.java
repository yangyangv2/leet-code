package prob167.two.sum.ii.input.array.is.sorted;

/**
 * Created by yanya04 on 8/14/2017.
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        if(numbers == null || numbers.length < 2){
            return new int[]{-1, -1};
        }

        int lo = 0, hi = numbers.length - 1;
        while(lo < hi){

            int sum = numbers[lo] + numbers[hi];
            if(sum == target){
                return new int[]{ lo + 1, hi + 1};
            } else if(sum < target){
                lo ++;
            } else if(sum > target){
                hi ++;
            }
        }

        return new int[]{-1, -1};
    }
}
