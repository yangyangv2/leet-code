package prob257.binary.tree.paths;

import utils.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, null);
        return result;
    }

    private void dfs(TreeNode node, List<String> result, String path){
        if(node == null) return;

        if(path == null) path = String.valueOf(node.val);
        else path = path + "->" + node.val;

        if(node.left == null && node.right == null){
            result.add(path);
            return;
        }

        dfs(node.left, result, path);
        dfs(node.right, result, path);
    }
}