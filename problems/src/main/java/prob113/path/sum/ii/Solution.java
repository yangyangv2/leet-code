package prob113.path.sum.ii;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanya04 on 10/1/2017.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> pathList = new ArrayList<>();
        Stack<Integer> path = new Stack<>();
        pathSum(root, sum, path, pathList);
        return pathList;
    }

    private void pathSum(TreeNode root, int sum, Stack<Integer> path, List<List<Integer>> pathList){

        if(root == null) return;

        path.push(root.val);

        if(root.left == null && root.right == null && root.val == sum){
            List<Integer> newPath = new ArrayList<>(path);
            pathList.add(newPath);
            path.pop();
            return;
        }

        pathSum(root.left, sum - root.val, path, pathList);
        pathSum(root.right, sum - root.val, path, pathList);

        path.pop();
    }
}
