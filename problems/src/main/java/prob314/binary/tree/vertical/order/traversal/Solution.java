package prob314.binary.tree.vertical.order.traversal;

import utils.tree.TreeNode;

import java.util.*;

/**
 * Created by yanya04 on 2/24/2018.
 */
public class Solution {

    /*
        tree traverse will not work, have to use BFS
    */

    private static class TreeNodeBean {
        TreeNode node;
        int offset;
        TreeNodeBean(TreeNode node, int offset)
        {
            this.node = node;
            this.offset = offset;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        // key: offset, value: node value
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<TreeNodeBean> queue = new LinkedList<>();
        queue.offer(new TreeNodeBean(root, 0));

        int min = 0;
        int max = 0;

        while(!queue.isEmpty())
        {
            Queue<TreeNodeBean> tempQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNodeBean tnBean = queue.poll();
                TreeNode node = tnBean.node;
                if(node == null) continue;

                int offset = tnBean.offset;

                min = Math.min(offset, min);
                max = Math.max(offset, max);

                List<Integer> list = map.get(offset);
                if(list == null){
                    list = new ArrayList<>();
                    map.put(offset, list);
                }
                list.add(node.val);

                tempQueue.offer(new TreeNodeBean(node.left, offset - 1));
                tempQueue.offer(new TreeNodeBean(node.right, offset + 1));
            }
            queue = tempQueue;
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = min; i <= max; i ++){
            List<Integer> list = map.get(i);
            if(list != null){
                res.add(map.get(i));
            }
        }
        return res;
    }

}