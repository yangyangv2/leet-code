package prob287.find.the.duplicate.number;

/**
 * Created by yanya04 on 8/7/2017.
 */
public class Solution {
    public int findDuplicate(int[] nums) {

/*
      index  0 1 2 3 4 5
      value1 1 4 5 2 3 0
      value2 1 4 4 2 3 0

      find1  1->4->3->2->5->0->1 done
      fild2  1->4->3->2->4       done
*/
        if(nums == null || nums.length == 1){
            return -1;
        }

        int fast = 0;
        int slow = 0;
        int slow2 = 0;

        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(fast == slow){
                break;
            }
        }

        while(true){
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2){
                return slow;
            }
        }
    }
}
