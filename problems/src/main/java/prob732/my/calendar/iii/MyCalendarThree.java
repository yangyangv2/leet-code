package prob732.my.calendar.iii;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 *  Created by yanya04 on 5/23/2018.
 */
public class MyCalendarThree {
    SegmentTree segmentTree;

    /*
        MyCalendarThree.book(10, 20); // returns 1
        MyCalendarThree.book(50, 60); // returns 1
        MyCalendarThree.book(10, 40); // returns 2
        MyCalendarThree.book(5, 15); // returns 3
        MyCalendarThree.book(5, 10); // returns 3
        MyCalendarThree.book(25, 55); // returns 3

    */

    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        calendar.print();

    }

    public MyCalendarThree() {
        segmentTree = new SegmentTree(0, 1000000000);
    }
    public int book(int start, int end) {
        segmentTree.add(start, end, 1);
        return segmentTree.getMax();
    }


    public void print(){
        segmentTree.print();
    }

    class SegmentTree {
        TreeNode root;
        public SegmentTree(int left, int right) {
            root = new TreeNode(left, right);
        }
        public void add(int start, int end, int val) {
            TreeNode event = new TreeNode(start, end);
            add(root, event, val);
        }

        private void print(){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int size = 0;
            while(!queue.isEmpty()){
                size = queue.size();
                while(size -- > 0){
                    TreeNode node = queue.poll();
                    System.out.print(String.format("[%s, %s (%s/%s)]\t", node.start, node.end, node.booked, node.total));

                    if(node.left!= null) queue.offer(node.left);
                    if(node.right!=null) queue.offer(node.right);

                }
                System.out.println("");
            }
        }

        private void add(TreeNode node, TreeNode event, int val) {
            if(node == null) {
                return ;
            }

            if(node.inside(event)) {
                node.booked += val;
                node.total += val;
            }

            if(node.intersect(event)) {
                // Recur for left and right children.
                int mid = (node.start + node.end) / 2;
                if(node.left == null) node.left = new TreeNode(node.start, mid);
                add(node.left, event, val);

                if(node.right == null) node.right = new TreeNode(mid, node.end);
                add(node.right, event, val);
                // Update current node using results of left and right calls.
                node.total = Math.max(node.left.total, node.right.total) + node.booked;
            }
        }
        public int getMax() {
            return root.total;
        }

        class TreeNode {
            int start, end;
            TreeNode left = null, right = null;
            // How much number is added to this interval(node)
            int booked = 0;
            // The maximum number in this interval(node).
            int total = 0;
            public TreeNode(int s, int t) {
                this.start = s;
                this.end = t;
            }
            public boolean inside(TreeNode b) {
                if(start >= b.start && end <= b.end) {
                    return true;
                }
                return false;
            }
            public boolean intersect(TreeNode b) {
                if(inside(b) || end <= b.start || b.end <= start) {
                    return false;
                }
                return true;
            }
        }
    }

}