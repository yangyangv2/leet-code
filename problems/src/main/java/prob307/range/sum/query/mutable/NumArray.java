package prob307.range.sum.query.mutable;

/**
 * Created by yanya04 on 9/4/2017.
 *
 * https://leetcode.com/articles/range-sum-query-mutable/
 *
 * https://www.youtube.com/watch?v=Oq2E2yGadnU&t=3s
 */
public class NumArray {

    private SegmentTree st;

    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
    }

    public void update(int i, int val) {
        st.update(i, val);
    }

    public int sumRange(int i, int j) {
        return st.sum(i, j);
    }


    private static class SegmentTree{

        private int n;
        private int[] data;

        SegmentTree(int[] nums){
            // init
            buildTree(nums);
        }


        void buildTree(int[] nums){
            this.n = nums.length;
            this.data = new int[n * 2];
            System.arraycopy(nums, 0, data, n, n);
            for(int i = n - 1; i >= 0; i --){
                data[i] = data[i * 2] + data[i * 2 + 1];
            }
        }

        void update(int index, int value){
            index = index + n;
            data[index] = value;
            while(index > 1){
                index >>= 1;
                data[index] = data[2 * index] + data[2 * index + 1];
            }
        }

        int sum(int left, int right){
            left += n; right += n;
            int sum = 0;
            while(left <= right){

                if(left % 2 != 0){
                    sum += data[left];
                    left ++;
                }

                if(right % 2 != 1){
                    sum += data[right];
                    right --;
                }
                left >>= 1;
                right >>= 1;
            }
            return sum;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
