package prob307.range.sum.query.mutable;

/**
 * Created by yanya04 on 9/4/2017.
 *
 * https://leetcode.com/articles/range-sum-query-mutable/
 *
 * https://www.youtube.com/watch?v=Oq2E2yGadnU&t=3s
 */
public class NumArray {

    private static interface Sum {
        public void update(int i, int val);
        public int getSumRange(int i , int j);
    }

    private static class BinaryIndexTree implements Sum{
        private int[] nums;
        private int[] bit;

        public BinaryIndexTree(int[] nums){
            this.nums = nums;
            init();
        }

        private void init(){
            bit = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i ++){
                add(i, nums[i]);
            }
        }

        private void add(int i, int val){
            int idx = i + 1;
            while(idx < bit.length){
                bit[idx] += val;
                idx += (idx & - idx);
            }
        }

        public void update(int i, int val){
            int diff = val - nums[i];
            nums[i] = val;
            add(i, diff);
        }

        private int getSum(int i ){
            int idx = i + 1;
            int sum = 0;
            while(idx > 0){
                sum += bit[idx];
                idx -= (idx & - idx);
            }
            return sum;
        }

        public int getSumRange(int i , int j){
            return getSum(j) - getSum(i - 1);
        }
    }


    private Sum sum;

    public NumArray(int[] nums) {
        sum = new BinaryIndexTree(nums);
    }



    public void update(int i, int val) {
        sum.update(i, val);
    }

    public int sumRange(int i, int j) {
        return sum.getSumRange(i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
