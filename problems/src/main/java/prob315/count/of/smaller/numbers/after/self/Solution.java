package prob315.count.of.smaller.numbers.after.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 3/5/2018.
 * Modified by yanya04 on 5/10/2018.
 * Modified by yanya04 on 5/26/2018.
 * Modified by yanya04 on 6/3/2018.
 */
public class Solution {
    /*
        use a segment tree to count the number of values smaller than the current value
    */


    public List<Integer> countSmaller(int[] nums) {

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num: nums){
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        SegTree st = new SegTree(min, max);

        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i --){
            st.insert(nums[i]);
            res.add(0, st.find(nums[i] - 1));
        }

        return res;
    }

    class Node {
        int start, end, count;
        Node left, right;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    class SegTree{

        Node root;
        SegTree(int min, int max){
            root = new Node(min, max);
        }

        void insert(int val){
            insert(root, val);
        }

        private void insert(Node node, int val){

            if(val > node.end || val < node.start) return;

            node.count ++;


            if(node.start == node.end) return;

            int mid = node.start + (node.end - node.start) / 2;

            if(val <= mid){
                if(node.left == null) node.left = new Node(node.start, mid);
                insert(node.left, val);
            } else {
                if(node.right == null) node.right = new Node(mid + 1, node.end);
                insert(node.right, val);
            }
        }

        int find(int val){
            return find(root, val);
        }

        private int find(Node node, int val){

            if(node == null || node.start > val) return 0;

            if(val >= node.end){
                return node.count;
            }

            int mid = node.start + (node.end - node.start) / 2;
            if(val <= mid){
                return find(node.left, val);
            } else {
                return find(node.left, val) + find(node.right, val);
            }
        }

    }

}