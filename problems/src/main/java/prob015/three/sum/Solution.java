package prob015.three.sum;

import java.util.*;

/**
 * Created by yanya04 on 7/22/2017.
 */
public class Solution {


    public static void main(String[] args) {
        int[] input = new int[]{0, 0};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(input));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // n*log(n)
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        for(int i = 0; i < nums.length; i ++){
            int target = nums[i];
            if(i > 0 && nums[i -1] == target) continue; // skip duplicates
            twosum(nums, i, result);
        }

        List<List<Integer>> resultUnique = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(List<Integer> list: result){
            Collections.sort(list);
            String key = String.valueOf(list);
            if(!set.contains(key)){
                resultUnique.add(list);
                set.add(key);
            }
        }

        return resultUnique;
    }
    //  two sum on sorted arrays
    private void twosum(int[] nums, int targetIndex, List<List<Integer>> result){

        int target = nums[targetIndex];
        int l = targetIndex + 1, r = nums.length - 1;
        while(l < r){
            if(l == targetIndex) {l ++; continue; }
            if(r == targetIndex) {r --; continue; }

            int s = target + nums[l] + nums[r];
            if(s == 0){
                List<Integer> list = new ArrayList<>(3);
                list.add(target); list.add(nums[l]); list.add(nums[r]);
                result.add(list);
                while(l < nums.length - 1 && nums[l] == nums[l + 1]) l ++;
                while(r > 0 && nums[r] == nums[r - 1]) r --;
                l ++; r--;
            } else if ( s > 0 ){
                r --;
            } else { // s < 0
                l ++;
            }
        }
    }
}