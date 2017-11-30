package prob216.combination.sum.iii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int m = 0;
        if (n > 9) {
            m = 9;
        } else {
            m = n;
        }

        int[] nums = new int[m];

        // get number 1 ~ max(n, 9)
        for (int i = 0; i < m; i++) {
            nums[i] = i + 1;
        }

        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums, k, n, 0, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int k, int n, int sum, int start) {
        if (temp.size() == k && sum == n) list.add(new ArrayList<Integer>(temp));
        if (sum > n) return;
        for (int i = start; i < nums.length; i++) {
            sum += nums[i];
            temp.add(nums[i]);
            backtrack(list, temp, nums, k, n, sum, i + 1);
            sum -= nums[i];
            temp.remove(temp.size() - 1);
        }
    }
}