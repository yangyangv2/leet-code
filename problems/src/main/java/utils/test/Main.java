package utils.test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        /*
        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> a - b);
        small.offer(1);
        small.offer(2);
        System.out.println(small.peek());

        PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> b - a);
        large.offer(1);
        large.offer(2);
        System.out.println(large.peek());

        for(int i = 0; i < 128; i ++){
            System.out.println( i + ": " + (i & -i) + " " + Integer.toBinaryString(i));
        }
*/
        int[] res = sort(new int[]{2, 1, 1 , 2, 3, 1, 1, 1});

        for(int num: res)
            System.out.println(num);
    }

    // 0, 1, 0 , 2, 0, 0, 5, 8
    //                 c
    //               p


    private static int[] sort(int[] nums){

        if(nums == null || nums.length == 0)
            return nums;

        int c = nums.length - 1;
        // use c to find next 0
        // use p to find next non-0, starting from c

        while(c >= 0)
        {
            while(c >= 0 && nums[c] != 0) c --;
            int p = c;
            while(p >= 0 && nums[p] == 0) p --;

            if(p >= 0 && c >= 0)
            {
                int temp = nums[p];
                nums[p] = nums[c];
                nums[c] = temp;
            }
            c --;
        }
        return nums;
    }
}
