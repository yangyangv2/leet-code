package prob732.my.calendar.iii;

/*
    Created by yanya04 on 6/3/2018.
 */
public class MyCalendarThree {

    private SegTree segTree;

    /*
        Unoptimized - optimization by saving the max value at each node
    */
    public MyCalendarThree() {
        segTree = new SegTree();
    }

    public int book(int start, int end) {
        segTree.book(start, end);
        return segTree.getMax();
    }

    class Node{
        int start, end, book;
        Node left, right;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    class SegTree{

        Node root;
        SegTree(){
            root = new Node(0, 1000000000);
        }

        void book(int start, int end){
            book(root, start, end);
        }

        private void book(Node node, int start, int end){
            if(node == null) return;
            if(node.end <= start || node.start >= end) return;

            if(start <= node.start && node.end <= end) {
                node.book ++;
                return;
            }

            int mid = node.start + (node.end - node.start) / 2;
            if(overlap(node.start, mid, start, end)){
                if(node.left == null) node.left = new Node(node.start, mid);
                book(node.left, start, end);
            }
            if(overlap(mid, node.end, start, end)){
                if(node.right == null) node.right = new Node(mid, node.end);
                book(node.right, start, end);
            }
        }

        int getMax(){
            return getMax(root);
        }

        private int getMax(Node node){
            if(node == null) return 0;
            return node.book + Math.max(getMax(node.left), getMax(node.right));
        }

        private boolean overlap(int s1, int e1, int s2, int e2){
            if(s1 >= e2 || e1 <= s2) return false;
            return true;
        }

    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */