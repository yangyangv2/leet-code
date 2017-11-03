package prob473.matchsticks.to.square;

import java.util.Arrays;

public class Solution {
    public boolean makesquare(int[] nums) {

        if (nums == null || nums.length < 4) return false;
        int sum = 0;

        for (Integer num : nums)
            sum += num;

        if (sum % 4 != 0) return false;
        int target = sum / 4;

        Arrays.sort(nums);

        int[] targets = new int[]{target, target, target, target};

        return dfs(nums, nums.length - 1, targets);
    }

    // loop through
    private boolean dfs(int[] nums, int index, int[] targets) {

        if (index < 0) {
            int sum = 0;
            for (Integer target : targets) sum += target;
            return sum == 0;
        }
        int num = nums[index];
        for (int i = 0; i < targets.length; i++) {
            if (targets[i] < num) continue;
            targets[i] -= num;  // borrow
            if (dfs(nums, index - 1, targets)) return true;
            targets[i] += num;  // return;
        }
        return false;
    }
}
