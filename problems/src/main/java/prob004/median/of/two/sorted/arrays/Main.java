package prob004.median.of.two.sorted.arrays;

import java.util.Arrays;

/**
 * Created by yanya04 on 7/22/2017.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,8,10};

        assert Arrays.binarySearch(nums, 3) == 2;

        assert Arrays.binarySearch(nums, 5) == -4;
        assert Arrays.binarySearch(nums, 6) == -4;

        assert Arrays.binarySearch(nums, 10) == 4;
        assert Arrays.binarySearch(nums, 11) == -6;

        assert Arrays.binarySearch(nums, 0) == -1;

        assert Arrays.binarySearch(nums, 1) == 0;

    }
}
