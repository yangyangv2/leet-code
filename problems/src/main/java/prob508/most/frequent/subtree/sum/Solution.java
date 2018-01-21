package prob508.most.frequent.subtree.sum;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 1/21/2018.
 */
public class Solution {

    private int max;
    // <sum, vals[]>
    private Map<Integer, Integer> freq;

    public int[] findFrequentTreeSum(TreeNode root) {

        max = Integer.MIN_VALUE;
        freq = new HashMap<>();
        sum(root);

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i ++)
            res[i] = list.get(i);

        return res;
    }

    // post order LRT
    private int sum(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        int sum = left + right + root.val;

        int count = freq.getOrDefault(sum, 0);
        if(max < count + 1)
            max = Math.max(max, count + 1);
        freq.put(sum, count + 1);
        return sum;
    }
}
