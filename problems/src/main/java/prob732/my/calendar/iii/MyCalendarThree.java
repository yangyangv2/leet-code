package prob732.my.calendar.iii;

import java.util.TreeMap;

/**
 *  Created by yanya04 on 5/23/2018.
 *  Modified by yanya04 on 6/2/2018.
 */
public class MyCalendarThree {
    SegmentTree segmentTree;
    public MyCalendarThree() {
        segmentTree = new SegmentTree(0, Integer.MAX_VALUE);
    }
    public int book(int start, int end) {
        segmentTree.add(start, end, 1);
        return segmentTree.getMax();
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
                if(b.start <= start && end <= b.end) {
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
