package prob449.serialize.and.deserialize.bst;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by yanya04 on 3/18/2018.
 */
public class Codec {

    /*


            4
          /   \
         2     7
         \    / \
          3  6   8

        4,2,7,X,3,6,7


    pre-order

    4,2,7,3,6,8

    */


    // Encodes a tree to a single string.

    /*
        Time:   O(n)
        Space:  O(n)
    */
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        preorder(root, list);
        return String.join(",", list);
    }

    private void preorder(TreeNode root, List<String> list){
        if(root == null) return;
        list.add(String.valueOf(root.val));
        preorder(root.left, list);
        preorder(root.right, list);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;

        String[] tokens = data.split(",");
        if(tokens.length == 0) return null;

        Queue<Integer> queue = new LinkedList<>();
        for(String token: tokens){
            queue.offer(Integer.parseInt(token));
        }

        TreeNode root = null;
        if(!queue.isEmpty()){
            root = new TreeNode(queue.poll());
            build(queue, root);
        }
        return root;
    }

    /*
        Time:   O(n^2)
        Space:  O(n)

    */
    private void build(Queue<Integer> queue, TreeNode parent){

        Queue<Integer> left = new LinkedList<>();
        while(! queue.isEmpty() && queue.peek() < parent.val){
            left.offer(queue.poll());
        }

        if(!left.isEmpty()){
            int leftVal = left.poll();
            parent.left = new TreeNode(leftVal);
            build(left, parent.left);
        }

        if(!queue.isEmpty()){
            int rightVal = queue.poll();
            parent.right = new TreeNode(rightVal);
            build(queue, parent.right);
        }
    }


}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));