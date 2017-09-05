package prob307.range.sum.query.mutable;

/**
 * Created by yanya04 on 9/4/2017.
 *
 * https://leetcode.com/articles/range-sum-query-mutable/
 *
 * https://www.youtube.com/watch?v=Oq2E2yGadnU&t=3s
 */
public class NumArray {


    private int[] arr;

    private int[] nums;
    public NumArray(int[] nums) {
        arr = construct(nums);
        this.nums = nums;
        //print();
    }

    private void print(){
        for(int i = 1; i < arr.length; i ++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void update(int i, int val) {

        //System.out.print("update(" + i + "," + val +"): ");

        int idx = i + nums.length;
        arr[idx] = val;
        nums[i] = val;
        while(idx > 1){
            idx = idx >> 1;
            arr[idx] = arr[2 * idx] + arr[2 * idx + 1];
        }

        //print();
    }

    public int sumRange(int i, int j) {

        //System.out.print("sum(" + i + "," + j +"): ");

        i += nums.length;
        j += nums.length;
        int sum = 0;
        while(i <= j){

            if(i % 2 == 1){ // odd number
                sum += arr[i++];
            }
            if(j % 2 == 0){
                sum += arr[j--];
            }

            i = i >> 1; j = j >> 1;

        }

        //print();

        return sum;
    }

    // construct segmentation tree
    private int[] construct(int[] nums){
        int n = nums.length;
        int[] arr = new int[n * 2];
        for(int i = 0; i < n; i ++){
            arr[i + n] = nums[i];
        }
        for(int i = n - 1; i > 0; i --){
            arr[i] = arr[2 * i] + arr[2 * i + 1];
        }
        return arr;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
