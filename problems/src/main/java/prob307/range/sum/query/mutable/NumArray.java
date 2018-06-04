package prob307.range.sum.query.mutable;

/**
 * Created by yanya04 on 9/4/2017.
 * Modified by yanya04 on 5/10/2018.
 * Modified by yanya04 on 5/21/2018.
 * Modified by yanya04 on 6/3/2018.
 *
 * https://leetcode.com/articles/range-sum-query-mutable/
 *
 * https://www.youtube.com/watch?v=Oq2E2yGadnU&t=3s
 */
class NumArray {
    private SegTree segTree;
    public NumArray(int[] nums) {
        segTree = new SegTree(nums);
    }

    public void update(int i, int val) {
        segTree.update(i, val);
    }

    public int sumRange(int i, int j) {
        return segTree.sum(i, j);
    }
    class Node {
        int start, end, sum;
        Node left, right;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    class SegTree{
        Node root;
        SegTree(int[] nums){
            root = new Node(0, nums.length - 1);
            for(int i = 0 ;i < nums.length; i ++){
                update(root, i, nums[i]);
            }
        }
        void update(int i, int val){
            update(root, i, val);
        }
        private void update(Node node, int i, int val){
            if(node.start == node.end){
                node.sum = val;
            } else {
                int mid = node.start + (node.end - node.start) / 2;
                if(node.left == null) node.left = new Node(node.start, mid);
                if(node.right == null) node.right = new Node(mid + 1, node.end);

                if(i <= mid){
                    update(node.left, i, val);
                } else {
                    update(node.right, i, val);
                }
                node.sum = node.left.sum + node.right.sum;
            }
        }

        int sum(int i, int j){
            return sum(root, i, j);
        }

        private int sum(Node node, int i, int j){
            if(node.start == i && node.end == j)
                return node.sum;
            else {
                int mid = node.start + (node.end - node.start) / 2;
                if(j <= mid) return sum(node.left, i, j);
                if(i > mid) return sum(node.right, i, j);
                return sum(node.left, i, mid) + sum(node.right, mid + 1, j);
            }
        }

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
