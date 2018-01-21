package prob501.find.mode.in.binary.search.tree;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

    private int max;

    private int count;
    private List<Integer> list;
    private int pre;

    public int[] findMode(TreeNode root) {
        max = Integer.MIN_VALUE;
        pre = Integer.MIN_VALUE;
        count = 1;
        list = new ArrayList<>();

        find(root);

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i ++)
            res[i] = list.get(i);

        return res;
    }

    /*
        inorder LTR traverse
    */
    private void find(TreeNode root){

        if(root == null) return;

        find(root.left);

        if(pre != root.val){
            pre = root.val;
            count = 1;
        } else {
            count ++;
        }

        if(count > max){
            list.clear();
            list.add(root.val);
            max = count;
        } else if (count == max){
            list.add(root.val);
        }

        find(root.right);

    }
}