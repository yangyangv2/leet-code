package prob297.serialize.and.deserialize.binary.tree;

import utils.tree.TreeNode;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yanya04 on 2/1/2018.
 * Modified by yanya04 on 5/13/2018.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;

        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()){
            cur = queue.poll();
            if(cur == null){
                list.add("X");
            } else {
                queue.offer(cur.left);
                queue.offer(cur.right);
                list.add(String.valueOf(cur.val));
            }
        }
        //System.out.println(String.join(",", list));
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //return null;
        if(data == null) return null;


        String[] nodes = data.split(",");
        int cursor = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0])), cur = null;
        String next = null;
        queue.offer(root);
        while(cursor < nodes.length){
            cur = queue.poll();
            next = nodes[cursor ++];
            if(!"X".equals(next)) {
                cur.left = new TreeNode(Integer.parseInt(next));
                queue.offer(cur.left);
            }
            if(cursor == nodes.length) break;
            next = nodes[cursor ++];
            if(!"X".equals(next)) {
                cur.right = new TreeNode(Integer.parseInt(next));
                queue.offer(cur.right);
            }
            if(cursor == nodes.length) break;
        }
        return root;
    }
}