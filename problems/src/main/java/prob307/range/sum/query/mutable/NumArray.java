package prob307.range.sum.query.mutable;

/**
 * Created by yanya04 on 9/4/2017.
 * Modified by yanya04 on 5/10/2018.
 *
 * https://leetcode.com/articles/range-sum-query-mutable/
 *
 * https://www.youtube.com/watch?v=Oq2E2yGadnU&t=3s
 */
public class NumArray {

    static class BIT{
        int[] sums;
        int[] nums;
        BIT(int[] nums){
            this.sums = new int[nums.length + 1];
            this.nums = new int[nums.length];
            for(int i = 0; i < nums.length; i ++){
                update(i, nums[i]);
            }
        }

        void update(int i, int val){
            int diff = val - nums[i];
            nums[i] = val;
            i ++;
            while(i < sums.length){
                sums[i] += diff;
                i += i & (-i);
            }
        }

        int find(int i){
            i ++;
            int sum = 0;
            while(i > 0){
                sum += sums[i];
                i -= i & (-i);
            }
            return sum;
        }

        void print(){

            System.out.print("index:\t");
            for(int i = 1; i < sums.length; i ++){
                System.out.print(i + "\t");
            }
            System.out.println("");
            System.out.print("bit:\t");
            for(int i = 1; i < sums.length; i ++){
                System.out.print(sums[i] + "\t");
            }
            System.out.println("");
            System.out.print("num:\t");
            for(int i = 0; i < nums.length; i ++){
                System.out.print(nums[i] + "\t");
            }
        }
    }


    private BIT bit;

    public NumArray(int[] nums) {
        this.bit = new BIT(nums);
    }

    public void update(int i, int val) {
        bit.update(i, val);
    }

    public int sumRange(int i, int j) {
        if(i == 0) return bit.find(j);
        else return bit.find(j) - bit.find(i - 1);
    }


    public static void main(String[] args) {


        int[] nums = new int[]{1, 3, 5};
        BIT bit = new BIT(nums);

        bit.print();

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
