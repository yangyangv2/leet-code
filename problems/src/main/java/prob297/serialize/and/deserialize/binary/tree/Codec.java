package prob297.serialize.and.deserialize.binary.tree;

import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yanya04 on 2/1/2018.
 */
public class Codec {

    // using X to represent null

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "X";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                list.add("X");
                continue;
            }
            list.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if("X".equals(data)) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for(int i = 1; i < nodes.length; i ++){

            TreeNode node = queue.poll();
            if(!nodes[i].equals("X")){
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(node.left);
            }

            if(++i == nodes.length) break;

            if(!nodes[i].equals("X")){
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(node.right);
            }
        }
        return root;
    }
}

