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

    /*  O(n)
    */
    public int[] findFrequentTreeSum(TreeNode root) {
        // sum / count
        Map<Integer, Integer> countMap = new HashMap<>();

        getTreeSum(root, countMap);

        int freq = 0;
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            if(freq <= entry.getValue()){
                freq = entry.getValue();
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()){
            if(entry.getValue() == freq){
                list.add(entry.getKey());
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            res[i] = list.get(i);
        }

        return res;
    }

    /*  O(n)
    */
    private int getTreeSum(TreeNode node, Map<Integer, Integer> countMap){
        if(node == null)
            return 0;
        int left = getTreeSum(node.left, countMap);
        int right = getTreeSum(node.right, countMap);
        int sum = left + right + node.val;

        countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        return sum;

    }
}
